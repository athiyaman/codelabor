package org.codelabor.example.services;

import org.codelabor.system.test.BaseTestCase;
import org.junit.Test;

public class HelloWorldServiceTest extends BaseTestCase {

	private HelloWorldService helloWorldService;

	@Override
	public void onSetUp() {
		helloWorldService = (HelloWorldService) applicationContext
				.getBean("helloWorldService");
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

}
