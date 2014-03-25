package org.codelabor.example.lifecycle.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.codelabor.system.web.util.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class
 * LifecycleServletRequestListener
 * 
 */
public class LifecycleServletRequestListener implements ServletRequestListener {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleServletRequestListener.class);

	/**
	 * Default constructor.
	 */
	public LifecycleServletRequestListener() {
		logger.debug("constructor");
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent event) {
		logger.debug("requestDestroyed");
		String sessionId = ServletUtils.getSessionId(event);
		logger.debug("session id: {}", sessionId);
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent event) {
		logger.debug("requestInitialized");
		String sessionId = ServletUtils.getSessionId(event);
		logger.debug("session id: {}", sessionId);
	}

}
