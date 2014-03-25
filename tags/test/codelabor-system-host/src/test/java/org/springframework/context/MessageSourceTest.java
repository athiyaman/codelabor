package org.springframework.context;

import java.util.Locale;

import org.codelabor.system.host.services.ServerMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

public class MessageSourceTest extends AbstractSingleSpringContextTests {
	private final static Logger logger = LoggerFactory
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
					.toString(), null, Locale.KOREAN);
			assertEquals("개발 모드", message);
			logger.debug("locale: {}, message: {}", Locale.KOREAN.toString(),
					message);

			message = messageSource.getMessage(ServerMode.DEVELOPMENT
					.toString(), null, Locale.US);
			assertEquals("Development Mode", message);
			logger.debug("locale: {}, message: {}", Locale.US.toString(),
					message);

			message = messageSource.getMessage(ServerMode.DEVELOPMENT
					.toString(), null, Locale.JAPANESE);
			assertEquals("Development モード", message);
			logger.debug("locale: {}, message: {}", Locale.JAPANESE.toString(),
					message);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testTranslate2() {
		try {
			String message = messageSource.getMessage("100.100.100.1", null,
					Locale.KOREAN);
			logger.debug("locale: {}, message: {}", Locale.KOREAN.toString(),
					message);

			message = messageSource
					.getMessage("100.100.100.1", null, Locale.US);
			logger.debug("locale: {}, message: {}", Locale.US.toString(),
					message);

			message = messageSource.getMessage("100.100.100.1", null,
					Locale.JAPANESE);
			logger.debug("locale: {}, message: {}", Locale.JAPANESE.toString(),
					message);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
