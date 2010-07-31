package org.codelabor.system.remoting.tcp.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

@SuppressWarnings("deprecation")
public class SocketAdapterServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	protected Log log = LogFactory.getLog(this.getClass());
	private SocketAdapterService SocketAdapterService;

	@Override
	public void onSetUp() throws Exception {
		SocketAdapterService = (SocketAdapterService) applicationContext
				.getBean("exampleRemotingTcpSimpleSocketAdapterService");
	}

	public void testSend() {
		int loopCount = 3;
		try {
			String inputMessage = "00000934SKSFSBAB075001RDEACI21SUA IBS350391640910212314246271000IBS350391640910212314246271                                0S 000        10.10.100.139           DITEAI1_SC2009102123142700                                                            053                                                                        IBSIBS0 IBS35039164           000003                        Z9001인터넷뱅킹          10NNN0                    00                           R                                                                                                                                                                                                                                                                                                                                                                  000000                                                                       0000002104238400                        ";
			for (int i = 0; i < loopCount; i++) {
				String outputMessage = SocketAdapterService.send(inputMessage);
				if (logger.isDebugEnabled()) {
					StringBuilder sb = new StringBuilder();
					sb.append("sent message: ").append(inputMessage).append(
							", ");
					sb.append("received message: ").append(outputMessage);
					logger.debug(sb.toString());
				}
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
