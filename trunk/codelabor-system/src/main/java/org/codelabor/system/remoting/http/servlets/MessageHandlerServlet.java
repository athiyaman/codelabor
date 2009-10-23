package org.codelabor.system.remoting.http.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		InputStream inputStream = request.getInputStream();

		// Reader reader = new InputStreamReader(inputStream);
		// int c;
		// while ((c = reader.read()) != -1) {
		// System.out.print((char) c);
		// }

		OutputStream outputStream = new ByteArrayOutputStream();
		ReadableByteChannel inputChannel = Channels.newChannel(inputStream);
		WritableByteChannel outputChannel = Channels.newChannel(outputStream);
		int messageLength = ChannelUtil.copy(inputChannel, outputChannel);
		String requestMessage = outputStream.toString();
		String responseMessage = requestMessage;

		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("contentLength: ").append(contentLength);
			sb.append(", ");
			sb.append("messageLength: ").append(messageLength);
			sb.append(", ");
			sb.append("requestMessage: ").append(requestMessage);
			sb.append(", ");
			sb.append("requestMessage: ").append(requestMessage);
			log.debug(sb.toString());
		}

		response.setContentType(contentType);
		response.getWriter().write(responseMessage);
	}
}
