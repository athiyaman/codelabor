package org.springframework.context;

import java.util.Locale;

import org.codelabor.system.test.BaseTestCase;
import org.junit.Test;

public class MessageResourceTest extends BaseTestCase {

	private MessageSource messageSource;

	@Override
	public void onSetUp() throws Exception {
		this.messageSource = (MessageSource) applicationContext
				.getBean("messageSource");
	}

	@Test
	public void testGetMessage() {
		try {
			// test
			String expectedMessage = "[Properties Service] Fail to refresh file properties [{0}].";
			String message = messageSource.getMessage(
					"error.properties.refresh.files", new Object[] {}, Locale
							.getDefault());
			// assert
			assertEquals(expectedMessage, message);
			log.debug(message);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
