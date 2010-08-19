package org.codelabor.system.certification.pki.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class RegistrationAuthorityServiceTest extends
		AbstractDependencyInjectionSpringContextTests {
	@Autowired
	protected RegistrationAuthorityService raService;

	public void testEnroll() {
		try {

			// RegistrationDTO registrationDTO = new RegistrationDTO();
			// registrationDTO.setId("bomber");
			// registrationDTO.setPassword("bomber");
			// registrationDTO.setRegistrationNumber("7504181117115");
			// raService.enroll(registrationDTO);
			// System.out.println(registrationDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	public void onSetUp() throws Exception {
		raService = (RegistrationAuthorityService) applicationContext
				.getBean("registrationAuthorityService");
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext-*.xml" };
	}
}
