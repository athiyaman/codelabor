package org.codelabor.system.remoting.http.servlets;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.remoting.http.services.MessageHandlerService;
import org.codelabor.system.servlets.BaseServlet;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ReflectionServiceInvokeServlet extends BaseServlet {

	private final Log log = LogFactory
			.getLog(ReflectionServiceInvokeServlet.class);
	public final static String SERVICE = "serviceName";
	public final static String METHOD = "methodName";
	public final static String MESSAGE = "message";

	protected String contentType = "text/html;charset=UTF-8";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		contentType = config.getInitParameter("contentType");
	}

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
		MessageHandlerService stringHandlerService = (MessageHandlerService) ctx
				.getBean(serviceName);

		try {
			Class myClass = stringHandlerService.getClass();
			Class[] paramTypes = new Class[] { String.class };
			Method myMethod = myClass.getMethod(methodName, paramTypes);
			Object[] paramList = new String[] { requestMessage };
			String responseMessage = (String) myMethod.invoke(
					stringHandlerService, paramList);
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("serviceName: ").append(serviceName);
				sb.append(", ");
				sb.append("methodName: ").append(methodName);
				sb.append(", ");
				sb.append("requestMessage: ").append(requestMessage);
				sb.append(", ");
				sb.append("responseMessage: ").append(responseMessage);
				log.debug(sb.toString());
			}
			response.setContentType(contentType);
			response.getWriter().write(responseMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}
}
