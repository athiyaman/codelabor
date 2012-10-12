package org.codelabor.example.lifecycle.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.codelabor.system.sniffer.web.util.ServletUtils;
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
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent event) {
		logger.debug("requestDestroyed");
		long threadId = Thread.currentThread().getId();
		String sessionId = ServletUtils.getSessionId(event);
		logger.debug("thread id: {}", threadId);
		logger.debug("session id: {}", sessionId);
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent event) {
		logger.debug("requestInitialized");
		long threadId = Thread.currentThread().getId();
		String sessionId = ServletUtils.getSessionId(event);
		logger.debug("thread id: {}", threadId);
		logger.debug("session id: {}", sessionId);
	}

}
