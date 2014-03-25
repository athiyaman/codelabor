package org.codelabor.example.io;

import java.io.File;
import java.io.IOException;

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

	@Test
	public void testCreateParentDirs() throws IOException {
		String directoryPath = "C:/temp/1/2/3/4/5/6/7/8/9/0";
		File directory = new File(directoryPath);
		if (directory.exists()) {
			Assert.assertTrue(directory.delete());
		}
		Files.createParentDirs(directory);

		String expectedDirectoryPath = "C:/temp/1/2/3/4/5/6/7/8/9";
		Assert.assertTrue(new File(expectedDirectoryPath).exists());
	}
}
