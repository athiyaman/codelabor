package org.codelabor.system.sniffer.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class
 * SniffingServletContextListener
 * 
 */
public class SniffingServletContextListener implements ServletContextListener {

	private final static Logger logger = LoggerFactory
			.getLogger(SniffingServletContextListener.class);

	/**
	 * Default constructor.
	 */
	public SniffingServletContextListener() {
		logger.debug("constructor");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		logger.debug("contextInitialized");

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {
		logger.debug("contextDestroyed");
	}

}
