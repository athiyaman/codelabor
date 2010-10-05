package org.codelabor.system.certification.pki.services;

import org.codelabor.system.certification.pki.dtos.RegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

@SuppressWarnings("deprecation")
public class RegistrationAuthorityServiceTest extends
		AbstractSingleSpringContextTests {

	private RegistrationAuthorityService registrationAuthorityService;
	protected Logger logger = LoggerFactory
			.getLogger(RegistrationAuthorityServiceTest.class);

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-configurableCallBack.xml",
				"classpath:/**/applicationContext-registrationAuthorityService.xml",
				"classpath:/**/applicationContext-queryService-oracle.xml",
				"classpath:/**/applicationContext-dataSourceService-oracle.xml",
				"classpath:/**/applicationContext-lobHandler.xml",
				"classpath:/**/applicationContext-nativeJdbcExtractor.xml" };
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
			logger.debug("registrationDTO: {}", registrationDTO);
		} catch (Exception e) {
			e.printStackTrace();
			// fail();
		}
	}

}
