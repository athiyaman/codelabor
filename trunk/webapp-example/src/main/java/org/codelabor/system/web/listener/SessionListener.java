package org.codelabor.system.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements HttpSessionListener {

	Logger logger = LoggerFactory.getLogger(SessionListener.class);

	public void sessionCreated(HttpSessionEvent event) {
		if (logger.isDebugEnabled()) {
			logger.debug("sessionCreated: {}", event.getSession().getId());
		}
		event.getSession().setAttribute("sessionData1", "value1");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		if (logger.isDebugEnabled()) {
			logger.debug("sessionDestroyed: {}", event.getSession().getId());
			logger.debug("session data1: {}", event.getSession().getAttribute(
					"sessionData1"));
		}

	}
}
