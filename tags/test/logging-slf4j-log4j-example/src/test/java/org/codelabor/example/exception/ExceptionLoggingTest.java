package org.codelabor.example.exception;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionLoggingTest {
	private Logger logger = LoggerFactory.getLogger(ExceptionLoggingTest.class);
	
	@Test
	public void logExceptionTest1() {
		try {
			if (true) {
				throw new Exception("some exception");
			}
		} catch (Exception e) {
			logger.error("exception: {}", e);
		}
	}
	
	@Test
	public void logExceptionTest2() {
		try {
			if (true) {
				throw new Exception("some exception");
			}
		} catch (Exception e) {
			logger.error("exception: {}", e.toString());
		}
	}	
}
