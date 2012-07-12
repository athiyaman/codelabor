package org.codelabor.example.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class HelloWorld {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorld.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoggerContext loggerContext = (LoggerContext) LoggerFactory
				.getILoggerFactory();
		StatusPrinter.print(loggerContext);

		MDC.put("username", "bomber");

		while (true) {
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
