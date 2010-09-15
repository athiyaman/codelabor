package org.springframework.context;

import org.apache.log4j.Logger;
import org.codelabor.system.host.services.ServerMode;
import org.springframework.test.AbstractSingleSpringContextTests;

public class MessageSourceTest extends AbstractSingleSpringContextTests {
	private final static Logger logger = Logger
			.getLogger(MessageSourceTest.class);
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

	public void testTranslate() {
		try {
			String message = messageSource.getMessage(ServerMode.DEVELOPMENT
					.toString(), null, null);
			logger.debug(message);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
