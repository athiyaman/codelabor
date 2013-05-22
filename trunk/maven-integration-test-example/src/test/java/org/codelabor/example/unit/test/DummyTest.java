package org.codelabor.example.unit.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyTest {

	Logger logger = LoggerFactory.getLogger(DummyTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		logger.debug("test");
	}

}
