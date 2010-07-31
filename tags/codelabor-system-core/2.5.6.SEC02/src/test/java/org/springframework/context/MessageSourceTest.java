package org.springframework.context;

import org.springframework.test.AbstractSingleSpringContextTests;

public class MessageSourceTest extends AbstractSingleSpringContextTests {

	private MessageSource messageSource;

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext-messageSource.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		this.messageSource = (MessageSource) applicationContext
				.getBean("messageSource");
	}

	public void testGetMessage() {
		try {
			// test
			String expectedMessage = "[Properties Service] Fail to refresh file properties [{0}].";
			String message = messageSource.getMessage(
					"error.properties.refresh.files", null, null);
			// assert
			assertEquals(expectedMessage, message);
			logger.debug(message);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
