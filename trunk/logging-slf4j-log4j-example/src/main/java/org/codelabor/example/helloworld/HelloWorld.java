package org.codelabor.example.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

	final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("Hello, World!");
		logger.debug("Hello, {}!", "bomber");
	}
}
