package org.codelabor.example.jasypt;

import org.jasypt.util.text.StrongTextEncryptor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrongTextEncryptorTest {

	private static final Logger logger = LoggerFactory
			.getLogger(StrongTextEncryptorTest.class);

	private StrongTextEncryptor strongTextEncryptor;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		strongTextEncryptor = new StrongTextEncryptor();
		strongTextEncryptor.setPassword("1234qwer");
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
		String encryptedMessage = strongTextEncryptor.encrypt(message);
		String decryptedMessage = strongTextEncryptor.decrypt(encryptedMessage);
		logger.debug("encryptedMessage: {}, decryptedMessage: {}",
				encryptedMessage, decryptedMessage);
		logger.debug("encryptedMessage.length: {}", encryptedMessage.length());
		logger.debug("decryptedMessage.length: {}", decryptedMessage.length());

	}

}
