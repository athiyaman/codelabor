package org.codelabor.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Log log = LogFactory.getLog(HelloWorld.class);
		if (log.isDebugEnabled()) {
			log.debug("Hello, World!");
		}
	}
}
