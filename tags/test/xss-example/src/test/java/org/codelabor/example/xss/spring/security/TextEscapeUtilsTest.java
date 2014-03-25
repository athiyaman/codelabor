package org.codelabor.example.xss.spring.security;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.util.TextEscapeUtils;

public class TextEscapeUtilsTest extends TestCase {
	Logger logger = LoggerFactory.getLogger(TextEscapeUtilsTest.class);

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEscapeEntities() {
		String beforeReplace = "<b>hello, world!</b>";
		logger.debug("beforeReplace: {}", beforeReplace);
		String afterReplace = TextEscapeUtils.escapeEntities(beforeReplace);
		logger.debug("TextEscapeUtils.escapeEntities: {}", afterReplace);
	}

}
