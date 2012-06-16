package org.codelabor.system.sniffer.web.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletUtils {
	private final static Logger logger = LoggerFactory
			.getLogger(ServletUtils.class);

	public static String getSessionId(ServletRequest request) {
		String sessionId = getSessionId((HttpServletRequest) request);
		logger.debug("session id: {}", sessionId);
		return sessionId;
	}

	public static String getSessionId(HttpServletRequest request) {
		HttpServletRequest httpServletRequest = request;
		HttpSession session = httpServletRequest.getSession();
		String sessionId = session.getId();
		logger.debug("session id: {}", sessionId);
		return sessionId;
	}

	public static String getSessionId(ServletRequestEvent event) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) event
				.getServletRequest();
		String sessionId = httpServletRequest.getSession().getId();
		logger.debug("session id: {}", sessionId);
		return sessionId;
	}

	public static String getContextPath(ServletContextEvent event) {
		String contextPath = event.getServletContext().getContextPath();
		logger.debug("context path: {}", contextPath);
		return contextPath;
	}

	public static String getServletContextPath(ServletContextEvent event) {
		String servletContextName = event.getServletContext()
				.getServletContextName();
		logger.debug("servlet context name: {}", servletContextName);
		return servletContextName;
	}

}
