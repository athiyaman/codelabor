package org.codelabor.example.jasypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jasypt.util.digest.Digester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigesterTest {

	private static final Logger logger = LoggerFactory
			.getLogger(DigesterTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDigest() throws NoSuchAlgorithmException {
		String before = "1234567890abcdefghijklmnopqrstuvwxyz";

		Digester digester = new Digester();
		byte[] beforeBytes1 = before.getBytes();
		byte[] afterBytes1 = digester.digest(beforeBytes1);
		BigInteger bigInteger1 = new BigInteger(beforeBytes1);
		String beforeHexa1 = bigInteger1.toString(16);
		bigInteger1 = new BigInteger(afterBytes1);
		String afterHexa1 = bigInteger1.toString(16);

		logger.debug("algorithm: {}", Digester.DEFAULT_ALGORITHM);
		logger.debug("before (String): {}", before);
		logger.debug("after (String): {}", new String(afterBytes1));
		logger.debug("before (Hexa): {}", beforeHexa1);
		logger.debug("after (Hexa): {}", afterHexa1);

		MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
		byte[] beforeBytes2 = before.getBytes();
		byte[] afterBytes2 = messageDigest.digest(beforeBytes2);
		BigInteger bigInteger2 = new BigInteger(beforeBytes2);
		String beforeHexa2 = bigInteger2.toString(16);
		bigInteger2 = new BigInteger(afterBytes2);
		String afterHexa2 = bigInteger2.toString(16);

		logger.debug("algorithm: {}", messageDigest.getAlgorithm());
		logger.debug("before (String): {}", before);
		logger.debug("after (String): {}", new String(afterBytes2));
		logger.debug("before (Hexa): {}", beforeHexa2);
		logger.debug("after (Hexa): {}", afterHexa2);
	}

}
