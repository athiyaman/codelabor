package org.codelabor.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class StatusPrinterTest {
	Logger logger = LoggerFactory.getLogger(StatusPrinterTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrint() {
		LoggerContext loggerContext = (LoggerContext) LoggerFactory
				.getILoggerFactory();
		StatusPrinter.print(loggerContext);
	}

}
