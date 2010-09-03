package org.codelabor.system.remoting.tcp.services;

import org.codelabor.system.remoting.tcp.services.SocketAdapterService;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class SocketAdapterServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private SocketAdapterService SocketAdapterService;

	@Override
	public void onSetUp() throws Exception {
		SocketAdapterService = (SocketAdapterService) applicationContext
				.getBean("exampleRemotingTcpSimpleSocketAdapterService");
	}

	public void testSend() {
		try {
			String inputMessage = "Hello, World!";
			String outputMessage = SocketAdapterService.send(inputMessage);
			if (logger.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("sent message: ").append(inputMessage).append(", ");
				sb.append("received message: ").append(outputMessage);
				logger.debug(sb.toString());
			}
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
