package org.codelabor.system.remoting.http.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.servlets.BaseHttpServlet;
import org.codelabor.system.utils.ChannelUtil;

public class MessageHandlerServlet extends BaseHttpServlet {

	private final Log log = LogFactory.getLog(MessageHandlerServlet.class);
	protected String contentType = "text/html;charset=UTF-8";
	protected int bufferSize = 512;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String paramContentType = config.getInitParameter("contentType");
		if (StringUtils.isNotBlank(paramContentType)) {
			contentType = paramContentType;
		}
		String paramBufferSize = config.getInitParameter("bufferSize");
		if (StringUtils.isNotBlank(paramContentType)
				&& StringUtils.isNumeric(paramBufferSize)) {
			bufferSize = Integer.parseInt(paramBufferSize);
		}
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int contentLength = request.getContentLength();
		Map parameterMap = request.getParameterMap();

		InputStream inputStream = request.getInputStream();

		Reader reader = new InputStreamReader(inputStream);
		int c;
		while ((c = reader.read()) != -1) {
			System.out.print((char) c);
		}

		OutputStream outputStream = new ByteArrayOutputStream();
		ReadableByteChannel inputChannel = Channels.newChannel(inputStream);
		WritableByteChannel outputChannel = Channels.newChannel(outputStream);
		int messageLength = ChannelUtil.copy(inputChannel, outputChannel);
		String requestMessage = outputStream.toString();
		String responseMessage = null;

		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("contentLength: ").append(contentLength);
			sb.append(", ");
			sb.append("parameterMap: ").append(parameterMap);
			sb.append(", ");
			sb.append("messageLength: ").append(messageLength);
			sb.append(", ");
			sb.append("requestMessage: ").append(requestMessage);
			log.debug(sb.toString());
		}

		// get bean
		//		
		// WebApplicationContext ctx = WebApplicationContextUtils
		// .getRequiredWebApplicationContext(getServletConfig()
		// .getServletContext());
		// StringHandlerService stringHandlerService = (StringHandlerService)
		// ctx
		// .getBean(serviceName);
		//
		// try {
		// Class myClass = stringHandlerService.getClass();
		// Class[] paramTypes = new Class[] { String.class };
		// Method myMethod = myClass.getMethod(methodName, paramTypes);
		// Object[] paramList = new String[] { requestMessage };
		// responseMessage = (String) myMethod.invoke(
		// stringHandlerService, paramList);
		// if (log.isDebugEnabled()) {
		// StringBuilder sb = new StringBuilder();
		// sb.append("serviceName: ").append(serviceName);
		// sb.append(", ");
		// sb.append("methodName: ").append(methodName);
		// sb.append(", ");
		// sb.append("requestMessage: ").append(requestMessage);
		// sb.append(", ");
		// sb.append("responseMessage: ").append(responseMessage);
		// log.debug(sb.toString());
		// }
		responseMessage = requestMessage;

		response.setContentType(contentType);
		response.getWriter().write(responseMessage);
		// } catch (Exception e) {
		// e.printStackTrace();
		// throw new ServletException(e);
		// }

	}
}
