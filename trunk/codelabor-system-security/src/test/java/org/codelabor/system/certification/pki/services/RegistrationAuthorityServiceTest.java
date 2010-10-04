package org.codelabor.system.certification.pki.services;

import org.codelabor.system.certification.pki.dtos.RegistrationDTO;
import org.springframework.test.AbstractSingleSpringContextTests;

public class RegistrationAuthorityServiceTest extends
		AbstractSingleSpringContextTests {

	private RegistrationAuthorityService registrationAuthorityService;

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-configurableCallBack.xml",
				"classpath:/**/applicationContext-registrationAuthorityService.xml",
				"classpath:/**/applicationContext-queryService-oracle.xml",
				"classpath:/**/applicationContext-dataSourceService-oracle.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		registrationAuthorityService = (RegistrationAuthorityService) applicationContext
				.getBean("registrationAuthorityService");
	}

	public void testEnroll() {
		try {
			RegistrationDTO registrationDTO = new RegistrationDTO();
			registrationDTO.setId("bomber");
			registrationDTO.setPassword("bomber");
			registrationDTO.setRegistrationNumber("");
			registrationAuthorityService.enroll(registrationDTO);
			System.out.println(registrationDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
