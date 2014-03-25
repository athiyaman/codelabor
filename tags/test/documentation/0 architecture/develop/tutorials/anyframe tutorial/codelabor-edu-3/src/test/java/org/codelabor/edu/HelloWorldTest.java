package org.codelabor.edu;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSayHello() {
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		String message = helloWorld.sayHello();
		Assert.assertEquals("Hello, World!", message);
	}

}
