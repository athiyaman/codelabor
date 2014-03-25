package org.codelabor.system.certification.pki.services;

import org.codelabor.system.certification.pki.CertificateType;
import org.codelabor.system.certification.pki.dtos.CodeDTO;
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
		try {
			CodeDTO code = raService.enroll("ȫ�浿", "1111111111111", null, CertificateType.PLATINUM_PRIVATE, true);
			System.out.println("reference code: "+code.getReferenceCode());
			System.out.println("distinguished name: "+code.getDistinguishedName());
			System.out.println("authorization code:"+code.getAuthorizationCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
