package org.codelabor.example;

import org.apache.log4j.Logger;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(HelloWorld.class);
		if (logger.isDebugEnabled()) {
			for (int i = 0; i < 100000; i++) {
				logger.debug("Hello, World!");
			}
		}
	}
}
