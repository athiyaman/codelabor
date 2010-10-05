package org.codelabor.system.userdetails.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.AbstractSingleSpringContextTests;

public class UserDetailsServiceTest extends AbstractSingleSpringContextTests {

	private UserDetailsService queryServiceUserDetailsService;
	protected Logger logger = LoggerFactory
			.getLogger(UserDetailsServiceTest.class);

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-configurableCallBack.xml",
				"classpath:/**/applicationContext-userDetailsService.xml",
				"classpath:/**/applicationContext-queryService-oracle.xml",
				"classpath:/**/applicationContext-dataSourceService-oracle.xml",
				"classpath:/**/applicationContext-lobHandler.xml",
				"classpath:/**/applicationContext-nativeJdbcExtractor.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		queryServiceUserDetailsService = (UserDetailsService) applicationContext
				.getBean("queryServiceUserDetailsService");
	}

	public void testLoadUserByUsername() {
		String userName = "admin";
		UserDetails userDetails = queryServiceUserDetailsService
				.loadUserByUsername(userName);
		logger.debug("userDetails: {}", userDetails);
		assertEquals(userName, userDetails.getUsername());
	}
}
