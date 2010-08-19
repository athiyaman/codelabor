package org.codelabor.system.dtos;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.codelabor.system.listeners.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionObject implements HttpSessionBindingListener {

	Logger logger = LoggerFactory.getLogger(SessionListener.class);

	public void valueBound(HttpSessionBindingEvent event) {
		if (logger.isDebugEnabled()) {
			logger.debug("valueBound: {}", event.getSession().getId());
		}
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		if (logger.isDebugEnabled()) {
			logger.debug("valueUnbound: {}", event.getSession().getId());
		}
	}

}
