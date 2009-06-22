package org.codelabor.edu;

import junit.framework.Assert;

import org.codelabor.edu.HelloWorld;
import org.codelabor.edu.HelloWorldImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HelloWorldTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSayHello() {
		HelloWorld helloWorld = new HelloWorldImpl();
		String message = helloWorld.sayHello();
		Assert.assertEquals("Hello, World!", message);
	}

}
