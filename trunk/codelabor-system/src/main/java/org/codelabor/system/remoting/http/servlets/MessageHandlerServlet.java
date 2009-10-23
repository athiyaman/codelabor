package org.codelabor.system.remoting.http.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.remoting.http.services.MessageHandlerService;
import org.codelabor.system.servlets.BaseHttpServlet;
import org.codelabor.system.utils.ChannelUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MessageHandlerServlet extends BaseHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2371693467388711297L;
	public final static String DEFAULT_METHOD = "handleMessage";
	private final Log log = LogFactory.getLog(MessageHandlerServlet.class);
	protected String contentType = "text/html;charset=UTF-8";
	protected int bufferSize = 512;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// get init parameter
		String paramContentType = config.getInitParameter("contentType");
		if (StringUtils.isNotBlank(paramContentType)) {
			contentType = paramContentType;
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
		int contentLength = request.getContentLength();

		// get input message
		InputStream inputStream = request.getInputStream();
		OutputStream outputStream = new ByteArrayOutputStream();
		ReadableByteChannel inputChannel = Channels.newChannel(inputStream);
		WritableByteChannel outputChannel = Channels.newChannel(outputStream);
		int messageLength = ChannelUtil.copy(inputChannel, outputChannel);
		String inputMessage = outputStream.toString();
		String outputMessage = null;
		MessageHandlerService stringHandlerService = null;
		try {
			// get bean
			WebApplicationContext ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletConfig()
							.getServletContext());
			stringHandlerService = (MessageHandlerService) ctx.getBean(this
					.getServiceName(inputMessage));

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
			response.getWriter().write(outputMessage);

			// log
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("contentLength: ").append(contentLength);
				sb.append(", ");
				sb.append("messageLength: ").append(messageLength);
				sb.append(", ");
				sb.append("inputMessage: ").append(inputMessage);
				sb.append(", ");
				sb.append("outputMessage: ").append(outputMessage);
				log.debug(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	protected String getServiceName(String message) throws Exception {
		String serviceName = message.substring(12, 23);
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("serviceName: ").append(serviceName);
			log.debug(sb.toString());
		}
		return serviceName;
	}

}
