package org.codelabor.example.io;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Files;

public class FilesTest {
	Logger logger = LoggerFactory.getLogger(FilesTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFileExtension() {
		String fileName = "C:\\Program Files (x86)\\Java\\jdk1.6.0_32\\bin\\java.exe";
		String fileExtension = Files.getFileExtension(fileName);
		logger.debug("file name: {}", fileName);
		logger.debug("file extension: {}", fileExtension);
		Assert.assertEquals("exe", fileExtension);

		fileName = "C:/Program Files (x86)/Java/jdk1.6.0_32/bin/java.exe";
		fileExtension = Files.getFileExtension(fileName);
		logger.debug("file name: {}", fileName);
		logger.debug("file extension: {}", fileExtension);
		Assert.assertEquals("exe", fileExtension);

		fileName = "C:\\Users\\bomber\\.m2\\settings.xml";
		fileExtension = Files.getFileExtension(fileName);
		logger.debug("file name: {}", fileName);
		logger.debug("file extension: {}", fileExtension);
		Assert.assertEquals("xml", fileExtension);

		fileName = "C:/Users/bomber/.m2/settings.xml";
		fileExtension = Files.getFileExtension(fileName);
		logger.debug("file name: {}", fileName);
		logger.debug("file extension: {}", fileExtension);
		Assert.assertEquals("xml", fileExtension);

	}
}
