package org.springframework.context;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class MessageSourceTest {

	@Autowired
	private MessageSource messageSource;
	private Logger logger = LoggerFactory.getLogger(MessageSourceTest.class);

	@Test
	public void testGetMessage() {
		String message = messageSource.getMessage("error.failure",
				new Object[] {}, Locale.US);
		logger.debug("message: {}", message);
	}
}
