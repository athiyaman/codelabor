package org.codelabor.system.userdetails.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.test.BaseTestCase;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserDetailsServiceTest extends BaseTestCase {

	private UserDetailsService queryServiceUserDetailsService;
	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public void onSetUp() throws Exception {
		queryServiceUserDetailsService = (UserDetailsService) applicationContext
				.getBean("queryServiceUserDetailsService");
	}

	public void testLoadUserByUsername() {
		String userName = "admin";
		UserDetails userDetails = queryServiceUserDetailsService
				.loadUserByUsername(userName);
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("userDetails: ").append(userDetails);
			log.debug(sb.toString());
		}
		assertEquals(userName, userDetails.getUsername());
	}
}
