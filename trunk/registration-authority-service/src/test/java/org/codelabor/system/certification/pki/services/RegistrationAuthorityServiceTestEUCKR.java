package org.codelabor.system.certification.pki.services;

import org.codelabor.system.certification.pki.CertificateType;
import org.codelabor.system.certification.pki.dtos.CodeDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration(locations = { "registration-authority-service.xml" })
public class RegistrationAuthorityServiceTestEUCKR extends
AbstractJUnit4SpringContextTests {
	@Autowired
	protected RegistrationAuthorityService raService;

	@Test
	public void enroll() {
		try {
			CodeDTO code = raService.enroll("Ω≈ªÛ¿Á", "7504181117115", null, CertificateType.PLATINUM_PRIVATE, true);
			System.out.println(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
