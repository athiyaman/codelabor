package org.codelabor.example.codepro.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DummyServiceTest {

	DummyService dummyService = new DummyService();

	@Test
	public void testSomeMethod1() {
		String data = dummyService.someMethod1("some data");
		assertEquals("[some data]", data);
	}

	@Test
	public void testSomeMethod2() {
		String data = dummyService.someMethod2("some data");
		assertEquals("[some data]", data);
	}

}
