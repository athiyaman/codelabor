package org.codelabor.example.lifecycle.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.codelabor.system.sniffer.web.util.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class LifecycleSessionListener
 * 
 */
public class LifecycleSessionListener implements HttpSessionListener {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleSessionListener.class);

	/**
	 * Default constructor.
	 */
	public LifecycleSessionListener() {
		logger.debug("constructor");
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		logger.debug("sessionCreated");
		String sessionId = ServletUtils.getSessionId(event);
		logger.debug("session id: {}", sessionId);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.debug("sessionDestroyed");
		String sessionId = ServletUtils.getSessionId(event);
		logger.debug("session id: {}", sessionId);
	}

}