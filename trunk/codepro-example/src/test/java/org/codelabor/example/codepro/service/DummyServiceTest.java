package org.codelabor.example.codepro.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DummyServiceTest {

	DummyService dummyService = new DummyService();

	@Test
	public void testAppendStringLiteral() {
		String data = dummyService.appendStringLiteral("some data");
		assertEquals("[some data]", data);
	}

	@Test
	public void testAppendCharacterLiteral() {
		String data = dummyService.appendCharacterLiteral("some data");
		assertEquals("[some data]", data);
	}

	@Test
	public void testExecuteCommand() {
		dummyService.executeCommand();
	}

}
