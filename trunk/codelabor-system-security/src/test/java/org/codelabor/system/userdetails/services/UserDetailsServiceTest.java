package org.codelabor.system.userdetails.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class UserDetailsServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private UserDetailsService queryServiceUserDetailsService;
	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public void onSetUp() throws Exception {
		queryServiceUserDetailsService = (UserDetailsService) applicationContext
				.getBean("queryServiceUserDetailsService");
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}

	public void testLoadUserByUsername() {
		String userName = "bomber";
		UserDetails userDetails = queryServiceUserDetailsService
				.loadUserByUsername(userName);
		if (log.isDebugEnabled()) {
			log.debug(userDetails);
		}
		assertEquals(userName, userDetails.getUsername());
	}
}
