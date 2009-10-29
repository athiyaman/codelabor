package org.codelabor.system.remoting.message.servlets;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.remoting.message.services.MessageHandlerService;
import org.codelabor.system.remoting.message.utils.MessageUtil;
import org.codelabor.system.servlets.BaseHttpServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MessageHandlerServlet extends BaseHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2371693467388711297L;
	public final static String DEFAULT_METHOD = "handleMessage";
	private final Log log = LogFactory.getLog(MessageHandlerServlet.class);
	protected String contentType = "text/html;charset=EUC-KR";
	protected String charsetName = "EUC-KR";
	protected int bufferSize = 8 * 1024;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// get init parameter
		String paramContentType = config.getInitParameter("contentType");
		if (StringUtils.isNotBlank(paramContentType)) {
			contentType = paramContentType;
		}
		String paramcharsetName = config.getInitParameter("charsetName");
		if (StringUtils.isNotBlank(paramcharsetName)) {
			charsetName = paramcharsetName;
		}
		String paramBufferSize = config.getInitParameter("bufferSize");
		if (StringUtils.isNotBlank(paramContentType)
				&& StringUtils.isNumeric(paramBufferSize)) {
			bufferSize = Integer.parseInt(paramBufferSize);
		}

		// log
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("contentType: ").append(contentType);
			sb.append(", ");
			sb.append("bufferSize: ").append(bufferSize);
			sb.append(", ");
			log.debug(sb.toString());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int contentLength = request.getContentLength();

			// get input message
			InputStream inputStream = request.getInputStream();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					byteArrayOutputStream);
			byte[] buffer = new byte[bufferSize];
			int readSize = 0;
			int totalReadSize = 0;
			while ((readSize = inputStream.read(buffer)) != -1
					&& (totalReadSize < contentLength)) {
				bufferedOutputStream.write(buffer, 0, readSize);
				bufferedOutputStream.flush();
				totalReadSize += readSize;
				if (log.isDebugEnabled()) {
					StringBuilder sb = new StringBuilder();
					sb.append("read size: ").append(readSize);
					sb.append(", ");
					sb.append("total read size: ").append(totalReadSize);
					log.debug(sb.toString());
				}
			}

			// message
			String inputMessage = new String(byteArrayOutputStream
					.toByteArray(), charsetName);
			String outputMessage = null;

			// get bean
			WebApplicationContext ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletConfig()
							.getServletContext());
			String serviceName = MessageUtil.getServiceName(inputMessage);
			MessageHandlerService stringHandlerService = (MessageHandlerService) ctx
					.getBean(serviceName);

			// invoke
			Class serviceClass = stringHandlerService.getClass();
			Class[] paramTypes = new Class[] { String.class };
			Method serviceMethod = serviceClass.getMethod(DEFAULT_METHOD,
					paramTypes);
			Object[] paramList = new String[] { inputMessage };
			outputMessage = (String) serviceMethod.invoke(stringHandlerService,
					paramList);

			// response
			response.setContentType(contentType);
			response.setCharacterEncoding(charsetName);
			response.getWriter().write(outputMessage);

			// log
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("content length: ").append(contentLength);
				sb.append(", ");
				sb.append("input message: [").append(inputMessage).append("]");
				sb.append(", ");
				sb.append("input message length: ").append(
						inputMessage.getBytes().length);
				sb.append(", ");
				sb.append("output message: [").append(outputMessage)
						.append("]");
				sb.append(", ");
				sb.append("output message length: ").append(
						outputMessage.getBytes().length);
				log.debug(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
