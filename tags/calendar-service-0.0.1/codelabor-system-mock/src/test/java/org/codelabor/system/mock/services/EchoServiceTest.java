package org.codelabor.system.mock.services;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

@SuppressWarnings("deprecation")
public class EchoServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	protected EchoService echoService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		echoService = (EchoService) applicationContext.getBean("echoService");
	}

	public void testEcho() {
		try {
			// test
			String inputMessage = "Hello, World!";
			String outputMessage = (String) echoService.echo(inputMessage);

			// assert
			assertEquals(inputMessage, outputMessage);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
