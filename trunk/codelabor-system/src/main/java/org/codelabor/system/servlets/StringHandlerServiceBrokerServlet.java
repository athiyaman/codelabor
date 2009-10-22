package org.codelabor.system.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.services.StringHandlerService;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class StringHandlerServiceBrokerServlet extends BaseServlet {

	private final Log log = LogFactory.getLog(StringHandlerServiceBrokerServlet.class);
	public final static String MESSAGE = "message";
	public final static String SERVICE = "service";

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		// get parameter
		String requestMessage = ServletRequestUtils.getStringParameter(request,
				MESSAGE);
		String serviceName = ServletRequestUtils.getStringParameter(request,
				SERVICE, "exampleEchoService");

		// get bean
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletConfig()
						.getServletContext());
		StringHandlerService stringHandlerService = (StringHandlerService) ctx
				.getBean(serviceName);

		try {
			String responseMessage = stringHandlerService
					.handleString(requestMessage);
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("requestMessage: ").append(requestMessage);
				sb.append(", ");
				sb.append("responseMessage: ").append(responseMessage);
				log.debug(sb.toString());
			}
			response.getWriter().write(responseMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
