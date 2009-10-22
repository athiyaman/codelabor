package org.codelabor.system.servlets;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.services.StringHandlerService;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ReflectionServiceInvokeServlet extends BaseServlet {

	private final Log log = LogFactory
			.getLog(ReflectionServiceInvokeServlet.class);
	public final static String SERVICE = "service";
	public final static String METHOD = "method";
	public final static String MESSAGE = "message";

	@SuppressWarnings("unchecked")
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		// get parameter
		String serviceName = ServletRequestUtils.getStringParameter(request,
				SERVICE);
		String methodName = ServletRequestUtils.getStringParameter(request,
				METHOD);
		String requestMessage = ServletRequestUtils.getStringParameter(request,
				MESSAGE);

		// get bean
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletConfig()
						.getServletContext());
		StringHandlerService stringHandlerService = (StringHandlerService) ctx
				.getBean(serviceName);

		Class myClass = stringHandlerService.getClass();
		try {
			Method myMethod = myClass.getMethod(methodName, String.class);
			String responseMessage = (String) myMethod.invoke(requestMessage);
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
