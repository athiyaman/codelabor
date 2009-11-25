package org.springframework.context;

import org.codelabor.system.test.BaseTestCase;

public class MessageSourceTest extends BaseTestCase {

	private MessageSource messageSource;

	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext-messageSource.xml" };
	}

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
			log.debug(message);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
