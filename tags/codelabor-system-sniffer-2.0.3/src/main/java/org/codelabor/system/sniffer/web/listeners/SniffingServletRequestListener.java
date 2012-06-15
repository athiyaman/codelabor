package org.codelabor.system.sniffer.web.listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SniffingServletRequestListener implements ServletRequestListener {

	private final static Logger logger = LoggerFactory
			.getLogger(SniffingServletRequestListener.class);

	public void requestDestroyed(ServletRequestEvent event) {
		ServletRequest request = event.getServletRequest();
		logger.debug(request.getRemoteAddr());
	}

	public void requestInitialized(ServletRequestEvent event) {
		ServletRequest request = event.getServletRequest();
		logger.debug(request.getRemoteAddr());
	}

}
