package org.codelabor.system.security.encoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.test.AbstractSingleSpringContextTests;

public class PasswordEncoderTest extends AbstractSingleSpringContextTests {

	private PasswordEncoder passwordEncoder;
	protected Logger logger = LoggerFactory.getLogger(PasswordEncoder.class);

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-passwordEncoder.xml",
				"classpath:/**/applicationContext-encryptService.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		// passwordEncoder = (PasswordEncoder) applicationContext
		// .getBean("passwordEncoder");
	}

	public void testEncode() {
		try {
			String plainPassword = "user1";
			String expectedEncodedPassword = "s9qne0wEqVUbh4HQMZH+CY8yXmc=";
			// String encodedPassword = passwordEncoder.encodePassword(
			// plainPassword, null);
			// logger.debug("plainPassword: {}", plainPassword);
			// logger.debug("encodedPassword: {}", encodedPassword);
			// assertEquals(expectedEncodedPassword, encodedPassword);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void isPasswordEncoder() {
		try {
			String plainPassword = "user1";
			String expectedEncodedPassword = "s9qne0wEqVUbh4HQMZH+CY8yXmc=";

			logger.debug("plainPassword: {}", plainPassword);
			logger
					.debug("expectedEncodedPassword: {}",
							expectedEncodedPassword);

			// assertTrue(passwordEncoder.isPasswordValid(expectedEncodedPassword,
			// plainPassword, null));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
