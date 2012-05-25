package org.codelabor.example.exception;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc	    : 
 * @Author  : 
 * @Date    : 2012. 5. 25.
 * @Version : 
 */

public class LoggingTest {

	private Logger logger = LoggerFactory.getLogger(LoggingTest.class);

	@Test
	public void debug() {
		String[] params = { "value1", "value2", "value3", "value4" };
		logger.debug("param1: {}, param2: {}, param3: {}, param4: {}", params);
		
	}

}
