package org.codelabor.example.io;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtilsTest {

	private final static Logger logger = LoggerFactory
			.getLogger(FilenameUtilsTest.class);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.apache.commons.io.FileUtils#forceMkdir(java.io.File)}.
	 */
	@Test
	public void testForceMkdir() {
		File directory = new File("c:/temp/sub1/sub2/sub3/sub4");
		try {
			FileUtils.forceMkdir(directory);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
