package org.codelabor.example;

import org.apache.log4j.Logger;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(HelloWorld.class);
		if (logger.isDebugEnabled()) {
			while (true) {
				// for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(1000);
					logger.debug("Hello, World!");
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(-1);
				}

			}
		}
	}
}
