package org.codelabor.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorld {
	private static final Log log = LogFactory.getLog(HelloWorld.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (log.isDebugEnabled()) {
			log.debug("Hello, World!");
		}
	}
}
