package org.codelabor.example.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicTextEncryptorTest {

	private static final Logger logger = LoggerFactory
			.getLogger(BasicTextEncryptorTest.class);

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

		BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
		basicTextEncryptor.setPassword("1234qwer");
		String encryptedMessage = basicTextEncryptor.encrypt(message);
		String decryptedMessage = basicTextEncryptor.decrypt(encryptedMessage);
		logger.debug("encryptedMessage.length: {}, encryptedMessage: {}",
				encryptedMessage.length(), encryptedMessage);
		logger.debug("decryptedMessage.length: {}, decryptedMessage: {}",
				decryptedMessage.length(), decryptedMessage);

		basicTextEncryptor = new BasicTextEncryptor();
		basicTextEncryptor.setPassword("qwer1234");
		encryptedMessage = basicTextEncryptor.encrypt(message);
		decryptedMessage = basicTextEncryptor.decrypt(encryptedMessage);
		logger.debug("encryptedMessage.length: {}, encryptedMessage: {}",
				encryptedMessage.length(), encryptedMessage);
		logger.debug("decryptedMessage.length: {}, decryptedMessage: {}",
				decryptedMessage.length(), decryptedMessage);

	}

}
