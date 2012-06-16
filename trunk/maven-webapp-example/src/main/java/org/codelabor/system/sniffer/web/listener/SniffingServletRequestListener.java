package org.codelabor.system.sniffer.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.codelabor.system.sniffer.web.util.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class
 * SniffingServletRequestListener
 * 
 */
public class SniffingServletRequestListener implements ServletRequestListener {

	private final static Logger logger = LoggerFactory
			.getLogger(SniffingServletRequestListener.class);

	/**
	 * Default constructor.
	 */
	public SniffingServletRequestListener() {
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
