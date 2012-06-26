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
		Digester digester = new Digester();
		String before = "before";
		byte[] beforeBytes = before.getBytes();
		byte[] afterBytes = digester.digest(beforeBytes);

		logger.debug("before (String): {}", before);
		logger.debug("after (String): {}", new String(afterBytes));

		BigInteger bigInteger = new BigInteger(beforeBytes);
		String beforeHexa = bigInteger.toString(16);
		bigInteger = new BigInteger(afterBytes);
		String afterHexa = bigInteger.toString(16);

		logger.debug("before (Hexa): {}", beforeHexa);
		logger.debug("after (Hexa): {}", afterHexa);
	}

}
