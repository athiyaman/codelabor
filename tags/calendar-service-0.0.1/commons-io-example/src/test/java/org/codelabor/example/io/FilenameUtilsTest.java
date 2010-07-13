package org.codelabor.example.io;

import junit.framework.TestCase;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilenameUtilsTest extends TestCase {

	private final static Logger logger = LoggerFactory
			.getLogger(FilenameUtilsTest.class);

	@Override
	public void setUp() throws Exception {
	}

	@Override
	public void tearDown() throws Exception {
	}

	public void testGetExtenstion() {
		String extension = FilenameUtils.getExtension("xxxx");
		logger.debug("extension: {}", extension);
		assertEquals("exe", extension);
	}

}
