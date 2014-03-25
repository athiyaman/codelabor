package org.codelabor.example.codepro.performance.service;

import static org.junit.Assert.assertEquals;

import org.codelabor.example.codepro.performance.service.AppendStringService;
import org.codelabor.example.codepro.performance.service.impl.AppendStringServiceImpl;
import org.junit.Test;

/**
 */
public class AppendStringServiceTest {

	AppendStringService appendStringService = new AppendStringServiceImpl();

	@Test
	public void testAppendStringLiteral() {
		String data = appendStringService.appendStringLiteral("some data");
		assertEquals("[some data]", data);
	}

	@Test
	public void testAppendCharacterLiteral() {
		String data = appendStringService.appendCharacterLiteral("some data");
		assertEquals("[some data]", data);
	}

}
