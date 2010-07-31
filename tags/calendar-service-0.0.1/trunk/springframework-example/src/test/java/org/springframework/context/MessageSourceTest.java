package org.springframework.context;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractSingleSpringContextTests;

public class MessageSourceTest extends AbstractSingleSpringContextTests {
	private final static Logger logger = Logger
			.getLogger(MessageSourceTest.class);
	private MessageSource messageSource;

	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext-messageSource.xml" };
	}

	public void onSetUp() throws Exception {
		this.messageSource = (MessageSource) applicationContext
				.getBean("messageSource");
	}

	public void testGetMessage() {
		try {
			// test
			String expectedMessage = "Hello, World!";
			String message = messageSource.getMessage("greeting", null, null);
			// assert
			assertEquals(expectedMessage, message);
			logger.debug(message);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
