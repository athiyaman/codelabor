package org.codelabor.example.remoting.services;

import org.codelabor.system.remoting.services.SocketAdapterService;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class SocketAdapterServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private SocketAdapterService SocketAdapterService;

	@Override
	public void onSetUp() throws Exception {
		SocketAdapterService = (SocketAdapterService) applicationContext
				.getBean("example.remoting.socketAdapterService");
	}

	public void testSend() {
		try {
			String inputMessage = "Hello, World!";
			String outputMessage = SocketAdapterService.send(inputMessage);
			if (logger.isDebugEnabled()) {
				logger.debug(outputMessage);
			}
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
