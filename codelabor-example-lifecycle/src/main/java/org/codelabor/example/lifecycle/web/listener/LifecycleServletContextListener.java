package org.codelabor.example.lifecycle.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class
 * LifecycleServletContextListener
 * 
 */
public class LifecycleServletContextListener implements ServletContextListener {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleServletContextListener.class);

	/**
	 * Default constructor.
	 */
	public LifecycleServletContextListener() {
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
