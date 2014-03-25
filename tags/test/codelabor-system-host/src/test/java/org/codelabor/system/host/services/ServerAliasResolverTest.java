package org.codelabor.system.host.services;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

/**
 * 서버 별명 리졸버 테스트 케이스
 * 
 * @author Shin Sangjae
 * 
 */
public class ServerAliasResolverTest extends AbstractSingleSpringContextTests {
	private final Logger logger = LoggerFactory
			.getLogger(ServerAliasResolverTest.class);

	/**
	 * 서버 별명 리졸버
	 */
	private ServerAliasResolver serverAliasResolver;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.AbstractSingleSpringContextTests#getConfigLocations
	 * ()
	 */
	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-serverAliasResolver.xml",
				"classpath:/**/applicationContext-messageSource.xml" };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.test.AbstractSingleSpringContextTests#onSetUp()
	 */
	@Override
	protected void onSetUp() throws Exception {
		this.serverAliasResolver = (ServerAliasResolver) applicationContext
				.getBean("serverAliasResolver");
	}

	/**
	 * 로컬 장비의 서버 별명를 가져온다.
	 */
	public void testGetServerAlias() {
		try {
			String serverAlias = serverAliasResolver.getServerAlias();
			logger.debug("serverAlias: {}", serverAlias);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * InetAddress 주소로 서버 별명를 가져온다.
	 */
	public void testGetStringByIpAddress() {
		try {
			byte[] address = InetAddress.getByName("100.100.100.1")
					.getAddress();
			InetAddress inetAddress = InetAddress.getByAddress(address);
			String serverAlias = serverAliasResolver
					.getServerAlias(inetAddress);
			logger.debug("inetAddress: {}, serverAlias: {}", inetAddress
					.getHostAddress(), serverAlias);

			address = InetAddress.getByName("100.100.110.1").getAddress();
			inetAddress = InetAddress.getByAddress(address);
			serverAlias = serverAliasResolver.getServerAlias(inetAddress);
			logger.debug("inetAddress: {}, serverAlias: {}", inetAddress
					.getHostAddress(), serverAlias);

			address = InetAddress.getByName("100.100.120.1").getAddress();
			inetAddress = InetAddress.getByAddress(address);
			serverAlias = serverAliasResolver.getServerAlias(inetAddress);
			logger.debug("inetAddress: {}, serverAlias: {}", inetAddress
					.getHostAddress(), serverAlias);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Raw IP 주소로 서버 별명를 가져온다.
	 */
	public void testGetStringByRawIpAddress() {
		try {
			String rawIpAddress = "100.100.100.1";
			String serverAlias = serverAliasResolver
					.getServerAliasByRawIpAddress(rawIpAddress);
			logger.debug("rawIpAddress: {}, serverAlias: {}", rawIpAddress,
					serverAlias);

			rawIpAddress = "100.100.110.1";
			serverAlias = serverAliasResolver
					.getServerAliasByRawIpAddress(rawIpAddress);
			logger.debug("rawIpAddress: {}, serverAlias: {}", rawIpAddress,
					serverAlias);

			rawIpAddress = "100.100.120.1";
			serverAlias = serverAliasResolver
					.getServerAliasByRawIpAddress(rawIpAddress);
			logger.debug("rawIpAddress: {}, serverAlias: {}", rawIpAddress,
					serverAlias);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Host명으로 서버 별명를 가져온다.
	 */
	public void testGetStringByHostName() {
		try {
			String hostName = "development01";
			String serverAlias = serverAliasResolver
					.getServerAliasByHostName(hostName);
			logger
					.debug("hostName: {}, serverAlias: {}", hostName,
							serverAlias);

			hostName = "staging01";
			serverAlias = serverAliasResolver
					.getServerAliasByHostName(hostName);
			logger
					.debug("hostName: {}, serverAlias: {}", hostName,
							serverAlias);

			hostName = "production01";
			serverAlias = serverAliasResolver
					.getServerAliasByHostName(hostName);
			logger
					.debug("hostName: {}, serverAlias: {}", hostName,
							serverAlias);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
