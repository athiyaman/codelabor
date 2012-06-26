package org.codelabor.example.jasypt;

import java.math.BigInteger;

import org.jasypt.util.digest.Digester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigesterTest {

	private static final Logger logger = LoggerFactory.getLogger(DigesterTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDigest() {
		String before = "1234567890abcdefghijklmnopqrstuvwxyz";

		Digester digester = new Digester();
		byte[] beforeBytes = before.getBytes();
		byte[] afterBytes = digester.digest(beforeBytes);
		BigInteger bigInteger = new BigInteger(beforeBytes);
		String beforeHexa = bigInteger.toString(16);
		bigInteger = new BigInteger(afterBytes);
		String afterHexa = bigInteger.toString(16);

		logger.debug("algorithm: {}", Digester.DEFAULT_ALGORITHM);
		logger.debug("before (String): {}", before);
		logger.debug("after (String): {}", new String(afterBytes));
		logger.debug("before (Hexa): {}", beforeHexa);
		logger.debug("after (Hexa): {}", afterHexa);

		digester = new Digester();
		digester.setAlgorithm("SHA-1");
		beforeBytes = before.getBytes();
		afterBytes = digester.digest(beforeBytes);
		bigInteger = new BigInteger(beforeBytes);
		beforeHexa = bigInteger.toString(16);
		bigInteger = new BigInteger(afterBytes);
		afterHexa = bigInteger.toString(16);

		logger.debug("algorithm: {}", "SHA-1");
		logger.debug("before (String): {}", before);
		logger.debug("after (String): {}", new String(afterBytes));
		logger.debug("before (Hexa): {}", beforeHexa);
		logger.debug("after (Hexa): {}", afterHexa);
	}

}
