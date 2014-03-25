package org.codelabor.system.sniffer.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestContextHolder {
	private static final ThreadLocal<RequestContext> contextHolder = new ThreadLocal<RequestContext>();
	private static final Logger logger = LoggerFactory
			.getLogger(RequestContextHolder.class);

	public static RequestContext getContext() {
		logger.debug("getContext");
		RequestContext requestContext = contextHolder.get();
		logger.debug("requestContext: {}", requestContext);
		return requestContext;
	}

	public static void removeContext() {
		RequestContext beforeUserContext = contextHolder.get();
		logger.debug("requestContext (before): {}", beforeUserContext);
		logger.debug("removeContext");
		contextHolder.remove();
		RequestContext afterUserContext = contextHolder.get();
		logger.debug("requestContext (after): {}", afterUserContext);
	}

	public static void setContext(RequestContext requestContext) {
		RequestContext beforeUserContext = contextHolder.get();
		logger.debug("requestContext (before): {}", beforeUserContext);
		logger.debug("setContext");
		contextHolder.set(requestContext);
		RequestContext afterUserContext = contextHolder.get();
		logger.debug("requestContext (after): {}", afterUserContext);
	}
}
