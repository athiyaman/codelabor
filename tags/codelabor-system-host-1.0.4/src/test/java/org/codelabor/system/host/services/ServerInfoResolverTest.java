package org.codelabor.system.host.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

/**
 * 서버 정보 리졸버 테스트 케이스
 * 
 * @author Shin Sangjae
 * 
 */
public class ServerInfoResolverTest extends AbstractSingleSpringContextTests {
	private final Logger logger = LoggerFactory
			.getLogger(ServerInfoResolverTest.class);

	/**
	 * 서버 정보 리졸버
	 */
	private ServerInfoResolver serverInfoResolver;

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
				"classpath:/**/applicationContext-serverInfoResolver.xml",
				"classpath:/**/applicationContext-messageSource.xml" };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.test.AbstractSingleSpringContextTests#onSetUp()
	 */
	@Override
	protected void onSetUp() throws Exception {
		this.serverInfoResolver = (ServerInfoResolver) applicationContext
				.getBean("serverInfoResolver");
	}

	/**
	 * 로컬 장비의 서버 정보를 가져온다.
	 */
	public void testGetServerInfo() {
		try {
			String serverAlias = serverInfoResolver.getServerAlias();
			logger.debug("serverAlias: {}", serverAlias);

			String serverDocumentTitle = serverInfoResolver
					.getServerDocumentTitle();
			logger.debug("serverDocumentTitle: {}", serverDocumentTitle);

			String serverMode = serverInfoResolver.getServerMode();
			logger.debug("serverMode: {}", serverMode);

			String serverWindowName = serverInfoResolver.getServerWindowName();
			logger.debug("serverWindowName: {}", serverWindowName);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
