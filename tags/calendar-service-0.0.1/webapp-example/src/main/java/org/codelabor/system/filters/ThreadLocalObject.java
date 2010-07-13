package org.codelabor.system.filters;

public class ThreadLocalObject {
	public static ThreadLocal<String> requestID = new ThreadLocal<String>();
}
