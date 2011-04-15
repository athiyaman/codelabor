package org.codelabor.example.io;

import static org.junit.Assert.assertEquals;

import org.apache.commons.io.FilenameUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilenameUtilsTest {

	private final static Logger logger = LoggerFactory
			.getLogger(FilenameUtilsTest.class);
	String fullyQualifiedFileNameOnUnix = "/Users/Name/sample/test.txt";
	String fullyQualifiedFileNameOnWindows = "C:\\Users\\Name\\sample\\test.txt";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNameOnUnix() {
		String name = FilenameUtils.getName(fullyQualifiedFileNameOnUnix);
		logger.debug("name: {}", name);
		assertEquals("test.txt", name);
	}

	@Test
	public void testGetNameOnWindows() {
		String name = FilenameUtils.getName(fullyQualifiedFileNameOnWindows);
		logger.debug("name: {}", name);
		assertEquals("test.txt", name);
	}

	@Test
	public void testGetExtenstionOnWindows() {
		String name = FilenameUtils.getName(fullyQualifiedFileNameOnUnix);
		String extension = FilenameUtils.getExtension(name);
		logger.debug("extension: {}", extension);
		assertEquals("txt", extension);
	}

	@Test
	public void testGetExtenstionOnUnix() {
		String name = FilenameUtils.getName(fullyQualifiedFileNameOnWindows);
		String extension = FilenameUtils.getExtension(name);
		logger.debug("extension: {}", extension);
		assertEquals("txt", extension);
	}

}
