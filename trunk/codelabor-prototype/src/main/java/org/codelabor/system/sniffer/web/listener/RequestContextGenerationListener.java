package org.codelabor.system.sniffer.web.listener;

import java.util.UUID;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.codelabor.system.sniffer.context.RequestContext;
import org.codelabor.system.sniffer.context.RequestContextHolder;
import org.codelabor.system.sniffer.context.RequestContextImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestContextGenerationListener implements ServletRequestListener {

	private static final Logger logger = LoggerFactory
			.getLogger(RequestContextGenerationListener.class);

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		logger.debug("requestDestroyed");
		logger.debug("request id: {}", RequestContextHolder.getContext()
				.getRequestId());
		RequestContextHolder.removeContext();
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		logger.debug("requestInitialized");
		UUID requestId = UUID.randomUUID();
		logger.info("request id: {}", requestId.toString());

		RequestContext context = RequestContextHolder.getContext();
		if (context == null) {
			context = new RequestContextImpl();
			context.setRequestId(requestId.toString());
			RequestContextHolder.setContext(context);
		}
		sre.getServletRequest().setAttribute("requestId", requestId.toString());
		logger.debug("request id: {}", RequestContextHolder.getContext()
				.getRequestId());
	}

}
