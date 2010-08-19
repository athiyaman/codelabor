package org.codelabor.system.security.encoder;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class PasswordEncoderTest extends AbstractDependencyInjectionSpringContextTests {

	private PasswordEncoder xecurePasswordEncoder;

	@Override
	public void onSetUp() throws Exception {
		xecurePasswordEncoder = (PasswordEncoder) applicationContext.getBean("xecurePasswordEncoder");
	}

	public void testEncode() {
		try {
			String plainPassword = "1234abcd가나다라";
			String encodedPassword = xecurePasswordEncoder.encodePassword(plainPassword, null);
			System.out.println("plainPassword: " + plainPassword);
			System.out.println("encodedPassword: " + encodedPassword);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext-passwordEncoder.xml", "classpath*:/**/applicationContext-encryptService.xml" };
	}
}
