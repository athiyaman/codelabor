package org.codelabor.example.helloworld.service;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldServiceTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private HelloWorldService helloWorldService = null;

	@Before
	public void setUp() throws Exception {
		helloWorldService = new HelloWorldServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSayHello() {
		String message = helloWorldService.sayHello();
		logger.debug("message: {}", message);
		Assert.assertEquals("Hello, World!", message);
	}

	@Test
	public void testSayHelloString() {
		String name = "Bomber";
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		Assert.assertEquals("Hello, Bomber!", message);
	}

}
