package org.codelabor.example.codepro.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DummyServiceTest {

	@Test
	public void testSomeMethod1() {
		DummyService dummyService = new DummyService();
		String data = dummyService.someMethod1("some data");
		assertEquals("[some data]", data);
	}

}
