package org.codelabor.system.host.services;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

/**
 * 서버 모드 리졸버 테스트 케이스
 * 
 * @author Shin Sangjae
 * 
 */
public class ServerModeResolverTest extends AbstractSingleSpringContextTests {
	private final Logger logger = LoggerFactory
			.getLogger(ServerModeResolverTest.class);

	/**
	 * 서버 모드 리졸버
	 */
	private ServerModeResolver serverModeResolver;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.AbstractSingleSpringContextTests#getConfigLocations
	 * ()
	 */
	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext-serverModeResolver.xml" };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.test.AbstractSingleSpringContextTests#onSetUp()
	 */
	@Override
	protected void onSetUp() throws Exception {
		this.serverModeResolver = (ServerModeResolver) applicationContext
				.getBean("serverModeResolver");
	}

	/**
	 * InetAddress 주소로 서버 모드를 가져온다.
	 */
	public void testGetServerModeByIpAddress() {
		try {
			byte[] address = InetAddress.getByName("100.100.100.1")
					.getAddress();
			InetAddress inetAddress = InetAddress.getByAddress(address);
			ServerMode serverMode = serverModeResolver
					.getServerMode(inetAddress);
			logger.debug("inetAddress: {}, serverMode: {}", inetAddress
					.getHostAddress(), serverMode.toString());
			assertEquals(ServerMode.DEVELOPMENT, serverMode);

			address = InetAddress.getByName("100.100.110.1").getAddress();
			inetAddress = InetAddress.getByAddress(address);
			serverMode = serverModeResolver.getServerMode(inetAddress);
			logger.debug("inetAddress: {}, serverMode: {}", inetAddress
					.getHostAddress(), serverMode.toString());
			assertEquals(ServerMode.STAGING, serverMode);

			address = InetAddress.getByName("100.100.120.1").getAddress();
			inetAddress = InetAddress.getByAddress(address);
			serverMode = serverModeResolver.getServerMode(inetAddress);
			logger.debug("inetAddress: {}, serverMode: {}", inetAddress
					.getHostAddress(), serverMode.toString());
			assertEquals(ServerMode.PRODUCTION, serverMode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Raw IP 주소로 서버 모드를 가져온다.
	 */
	public void testGetServerModeByRawIpAddress() {
		try {
			String rawIpAddress = "100.100.100.1";
			ServerMode serverMode = serverModeResolver
					.getServerModeByRawIpAddress(rawIpAddress);
			logger.debug("rawIpAddress: {}, serverMode: {}", rawIpAddress,
					serverMode.toString());
			assertEquals(ServerMode.DEVELOPMENT, serverMode);

			rawIpAddress = "100.100.110.1";
			serverMode = serverModeResolver
					.getServerModeByRawIpAddress(rawIpAddress);
			logger.debug("rawIpAddress: {}, serverMode: {}", rawIpAddress,
					serverMode.toString());
			assertEquals(ServerMode.STAGING, serverMode);

			rawIpAddress = "100.100.120.1";
			serverMode = serverModeResolver
					.getServerModeByRawIpAddress(rawIpAddress);
			logger.debug("rawIpAddress: {}, serverMode: {}", rawIpAddress,
					serverMode.toString());
			assertEquals(ServerMode.PRODUCTION, serverMode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Host명으로 서버 모드를 가져온다.
	 */
	public void testGetServerModeByHostName() {
		try {
			String hostName = "development01";
			ServerMode serverMode = serverModeResolver
					.getServerModeByHostName(hostName);
			logger.debug("hostName: {}, serverMode: {}", hostName, serverMode
					.toString());
			assertEquals(ServerMode.DEVELOPMENT, serverMode);

			hostName = "staging01";
			serverMode = serverModeResolver.getServerModeByHostName(hostName);
			logger.debug("hostName: {}, serverMode: {}", hostName, serverMode
					.toString());
			assertEquals(ServerMode.STAGING, serverMode);

			hostName = "production01";
			serverMode = serverModeResolver.getServerModeByHostName(hostName);
			logger.debug("hostName: {}, serverMode: {}", hostName, serverMode
					.toString());
			assertEquals(ServerMode.PRODUCTION, serverMode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
