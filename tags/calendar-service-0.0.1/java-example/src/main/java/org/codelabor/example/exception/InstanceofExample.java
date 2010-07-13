package org.codelabor.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstanceofExample {

	private static final Logger logger = LoggerFactory
			.getLogger(InstanceofExample.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exception2 exception2 = new Exception2();

		if (exception2 instanceof Exception) {
			logger.debug("exception2 instanceof Exception");
		}
		if (exception2 instanceof Exception1) {
			logger.debug("exception2 instanceof Exception1");
		}
		if (exception2 instanceof Exception2) {
			logger.debug("exception2 instanceof Exception2");
		}

	}

}
