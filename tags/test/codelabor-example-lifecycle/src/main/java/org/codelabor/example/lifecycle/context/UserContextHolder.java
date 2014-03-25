package org.codelabor.example.lifecycle.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserContextHolder {
	private static final ThreadLocal<UserContext> contextHolder = new ThreadLocal<UserContext>();
	private static final Logger logger = LoggerFactory
			.getLogger(UserContextHolder.class);

	public static UserContext getContext() {
		logger.debug("getContext");
		UserContext userContext = contextHolder.get();
		logger.debug("userContext: {}", userContext);
		return userContext;
	}

	public static void setContext(UserContext userContext) {
		UserContext beforeUserContext = contextHolder.get();
		logger.debug("userContext (before): {}", beforeUserContext);
		logger.debug("setContext");
		contextHolder.set(userContext);
		UserContext afterUserContext = contextHolder.get();
		logger.debug("userContext (after): {}", afterUserContext);
	}

	public static void removeContext() {
		UserContext beforeUserContext = contextHolder.get();
		logger.debug("userContext (before): {}", beforeUserContext);
		logger.debug("removeContext");
		contextHolder.remove();
		UserContext afterUserContext = contextHolder.get();
		logger.debug("userContext (after): {}", afterUserContext);
	}
}
