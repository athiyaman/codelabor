package org.codelabor.system.certification.pki.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration(locations = { "registration-authority-service.xml" })
public class RegistrationAuthorityServiceTest extends
AbstractJUnit4SpringContextTests {
	@Autowired
	protected RegistrationAuthorityService raService;

	@Test
	public void enroll() {
		
	}
}
