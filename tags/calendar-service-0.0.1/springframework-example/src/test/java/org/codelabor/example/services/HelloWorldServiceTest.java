package org.codelabor.example.services;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractSingleSpringContextTests;

public class HelloWorldServiceTest extends AbstractSingleSpringContextTests {
	private final static Logger logger = Logger
			.getLogger(HelloWorldServiceTest.class);
	private HelloWorldService helloWorldService;

	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-advice.xml",
				"classpath:/**/applicationContext-pointcut.xml",
				"classpath:/**/applicationContext-transactionManager-dataSource.xml",
				"classpath:/**/applicationContext-dataSource-dbcp.xml",
				"classpath:/**/applicationContext-helloWorldService.xml",
				"classpath:/**/applicationContext-helloWorldManager.xml",
				"classpath:/**/applicationContext-helloWorldDAO.xml" };
	}

	public void onSetUp() throws Exception {
		this.helloWorldService = (HelloWorldService) applicationContext
				.getBean("helloWorldService");
	}

	public void testGetMessage() {
		try {
			// test
			String greeting = helloWorldService.sayHello();
			logger.debug(greeting);
			String expectedGreeting = "Hello, World!";
			assertEquals(expectedGreeting, greeting);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
