package org.codelabor.system.certification.pki.services;

import org.codelabor.system.test.BaseTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationAuthorityServiceTest extends BaseTestCase {
	@Autowired
	protected RegistrationAuthorityService raService;

	public void testEnroll() {
		try {
			// RegistrationDTO registrationDTO = new RegistrationDTO();
			// registrationDTO.setId("bomber");
			// registrationDTO.setPassword("bomber");
			// registrationDTO.setRegistrationNumber("");
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
}
