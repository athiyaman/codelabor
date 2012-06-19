package org.codelabor.example.lifecycle.context;

import junit.framework.Assert;

public class UserContextHolder {
	private static final ThreadLocal<UserContext> contextHolder = new ThreadLocal<UserContext>();

	public static UserContext getContext() {
		UserContext temp = contextHolder.get();
		if (temp == null) {
			return new UserContextImpl();
		} else {
			return temp;
		}
	}

	public static void setContext(UserContext userContext) {
		Assert.assertNotNull(userContext);
		contextHolder.set(userContext);
	}
}
