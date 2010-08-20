package org.codelabor.example.lang;

import java.io.InputStream;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassLoaderTest extends TestCase {

	Logger logger = LoggerFactory.getLogger(ClassLoaderTest.class);

	public void testGetResourceAsStream() {
		try {
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("log4j.xml");
			logger.debug("inputStream: {}", inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
}
