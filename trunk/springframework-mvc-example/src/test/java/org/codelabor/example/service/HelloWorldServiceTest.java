package org.codelabor.example.service;

import junit.framework.Assert;

import org.codelabor.example.helloworld.service.HelloWorldService;
import org.codelabor.example.helloworld.service.HelloWorldServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldServiceTest {

	private Logger logger = LoggerFactory
			.getLogger(HelloWorldServiceTest.class);
	private HelloWorldService helloWorldService = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		helloWorldService = new HelloWorldServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSayHello() {
		try {
			String message = helloWorldService.sayHello();
			logger.debug("message: {}", message);
			Assert.assertEquals("Hello, World!", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSayHelloString() {
		String name = "Bomber";
		try {
			String message = helloWorldService.sayHello(name);
			logger.debug("message: {}", message);
			Assert.assertEquals("Hello, Bomber!", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
