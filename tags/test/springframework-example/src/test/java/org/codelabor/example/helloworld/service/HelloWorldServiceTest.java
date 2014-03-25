package org.codelabor.example.helloworld.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext*.xml")
public class HelloWorldServiceTest {
	private final static Logger logger = LoggerFactory.getLogger(HelloWorldServiceTest.class);
	@Autowired
	private ApplicationContext ctx;
	private HelloWorldService helloWorldService;

	@Before
	public void setUp() {
		this.helloWorldService = ctx.getBean("helloWorldService", HelloWorldService.class);
	}

	@Test
	public void testGetMessage() {
		try {
			// test
			String greeting = helloWorldService.sayHello();
			String expectedGreeting = "Hello, World!";
			assertEquals(expectedGreeting, greeting);
			logger.debug("greeting: {}", greeting);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
