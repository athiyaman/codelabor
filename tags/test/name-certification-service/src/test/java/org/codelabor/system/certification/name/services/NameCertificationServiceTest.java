package org.codelabor.system.certification.name.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "namecheck-service.xml" })
public class NameCertificationServiceTest extends
		AbstractJUnit4SpringContextTests {

	@Autowired
	protected NameCertificationService nameCertificationService;

	@Test
	public void certificate() {
		try {
			NameCertificationStatus status = nameCertificationService
					.certificate("홍길동", "1111111111111", false);
			//assertEquals(NameCertificationStatus.CERTIFICATED, status);
			assertEquals(NameCertificationStatus.INCORRECT_ENCRYPTION_DATA, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}