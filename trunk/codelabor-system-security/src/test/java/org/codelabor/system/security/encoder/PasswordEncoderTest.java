package org.codelabor.system.security.encoder;

import org.codelabor.system.test.BaseTestCase;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class PasswordEncoderTest extends BaseTestCase {

	private PasswordEncoder passwordEncoder;

	@Override
	public void onSetUp() throws Exception {
		passwordEncoder = (PasswordEncoder) applicationContext
				.getBean("xecurePasswordEncoder");
	}

	public void testEncode() {
		try {
			String plainPassword = "user1";
			String expectedEncodedPassword = "s9qne0wEqVUbh4HQMZH+CY8yXmc=";
			String encodedPassword = passwordEncoder.encodePassword(
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

			assertTrue(passwordEncoder.isPasswordValid(expectedEncodedPassword,
					plainPassword, null));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-passwordEncoder.xml",
				"classpath:/**/applicationContext-encryptService.xml" };
	}
}
