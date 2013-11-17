package org.codelabor.example.lifecycle.context;

public class UserContextHolder {
	private static final ThreadLocal<UserContext> contextHolder = new ThreadLocal<UserContext>();

	public static UserContext getContext() {
		UserContext context = contextHolder.get();
		return context;
	}

	public static void setContext(UserContext userContext) {
		assert userContext != null;
		contextHolder.set(userContext);
	}

	public static void removeContext() {
		contextHolder.remove();
	}
}
