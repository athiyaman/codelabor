package org.codelabor.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorld.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
