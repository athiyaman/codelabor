package org.codelabor.system.security.encoder;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class PasswordEncoderTest extends
		AbstractDependencyInjectionSpringContextTests {

	private PasswordEncoder xecurePasswordEncoder;

	@Override
	public void onSetUp() throws Exception {
		xecurePasswordEncoder = (PasswordEncoder) applicationContext
				.getBean("xecurePasswordEncoder");
	}

	public void testEncode() {
		try {
			String plainPassword = "user1";
			String expectedEncodedPassword = "s9qne0wEqVUbh4HQMZH+CY8yXmc=";
			String encodedPassword = xecurePasswordEncoder.encodePassword(
					plainPassword, null);

			System.out.println("plainPassword: " + plainPassword);
			System.out.println("encodedPassword: " + encodedPassword);
			assertEquals(expectedEncodedPassword, encodedPassword);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void isPasswordEncoder() {
		try {
			String plainPassword = "user1";
			String expectedEncodedPassword = "s9qne0wEqVUbh4HQMZH+CY8yXmc=";

			System.out.println("plainPassword: " + plainPassword);
			System.out.println("expectedEncodedPassword: "
					+ expectedEncodedPassword);

			assertTrue(xecurePasswordEncoder.isPasswordValid(
					expectedEncodedPassword, plainPassword, null));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath*:/**/applicationContext-passwordEncoder.xml",
				"classpath*:/**/applicationContext-encryptService.xml" };
	}
}
