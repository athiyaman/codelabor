package org.codelabor.example.services;

import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class HelloWorldServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private HelloWorldService helloWorldService;

	@Override
	public void onSetUp() {
		helloWorldService = (HelloWorldService) applicationContext
				.getBean("exampleHelloWorldService");
	}

	@Test
	public void testSayHello() {
		String greeting = null;
		try {
			greeting = helloWorldService.sayHello();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Hello, World!", greeting);
	}

	@Test
	public void testSayHelloString() {
		String greeting = null;
		try {
			greeting = helloWorldService.sayHello("Bomber");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Hello, Bomber!", greeting);
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}

}
