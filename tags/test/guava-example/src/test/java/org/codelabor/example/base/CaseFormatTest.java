package org.codelabor.example.base;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CaseFormat;

public class CaseFormatTest {

	Logger logger = LoggerFactory.getLogger(CaseFormatTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTo() {
		String beforeString = "abcDefGhiJklMnoPqrStuVwxYz";
		String afterString = null;
		afterString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN,
				beforeString);
		logger.debug("before: {}", beforeString);
		logger.debug("after: {}", afterString);

		afterString = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,
				afterString);
		logger.debug("before: {}", beforeString);
		logger.debug("after: {}", afterString);

		Assert.assertEquals(beforeString, afterString);
	}

	@Test
	public void testTo2() {
		String beforeString = "abcdefghijklmnopqrstuvwxyz";
		String afterString = null;
		afterString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN,
				beforeString);
		logger.debug("before: {}", beforeString);
		logger.debug("after: {}", afterString);

		afterString = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,
				afterString);
		logger.debug("before: {}", beforeString);
		logger.debug("after: {}", afterString);

		Assert.assertEquals(beforeString, afterString);
	}

	@Test
	public void testTo3() {
		String beforeString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String afterString = null;
		afterString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN,
				beforeString);
		logger.debug("before: {}", beforeString);
		logger.debug("after: {}", afterString);

		afterString = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,
				afterString);
		logger.debug("before: {}", beforeString);
		logger.debug("after: {}", afterString);

		Assert.assertNotSame(beforeString, afterString);
	}
}
