package org.codelabor.example.lifecycle.context;

public class UserContextHolder {
	private static final ThreadLocal<UserContext> contextHolder = new ThreadLocal<UserContext>();

	public static UserContext getContext() {
		return contextHolder.get();
	}

	public static void setContext(UserContext userContext) {
		contextHolder.set(userContext);
	}
}
