package org.codelabor.example.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardPBEStringEncryptorTest {

	private static final Logger logger = LoggerFactory
			.getLogger(StandardPBEStringEncryptorTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Algorithm: PBEWithMD5AndDES.
	 */
	@Test
	public final void testEncrypt() {
		String message = "010-1111-1111";

		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		standardPBEStringEncryptor.setPassword("1234qwer");
		String encryptedMessage = standardPBEStringEncryptor.encrypt(message);
		String decryptedMessage = standardPBEStringEncryptor
				.decrypt(encryptedMessage);
		logger.debug("encryptedMessage.length: {}, encryptedMessage: {}",
				encryptedMessage.length(), encryptedMessage);
		logger.debug("decryptedMessage.length: {}, decryptedMessage: {}",
				decryptedMessage.length(), decryptedMessage);

		standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		standardPBEStringEncryptor.setPassword("qwer1234");
		encryptedMessage = standardPBEStringEncryptor.encrypt(message);
		decryptedMessage = standardPBEStringEncryptor.decrypt(encryptedMessage);
		logger.debug("encryptedMessage.length: {}, encryptedMessage: {}",
				encryptedMessage.length(), encryptedMessage);
		logger.debug("decryptedMessage.length: {}, decryptedMessage: {}",
				decryptedMessage.length(), decryptedMessage);

	}

}
