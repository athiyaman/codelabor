/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabr.system.util;

import org.codelabor.system.util.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-jae
 * 
 */
@SuppressWarnings("deprecation")
public class FileUtilsTest {

	String fullyQualifiedFilenameOnUnix = "/Users/Name/sample/test.txt";
	String fullyQualifiedFilenameOnWindows = "C:\\Users\\Name\\sample\\test.txt";
	// 로거
	Logger logger = LoggerFactory.getLogger(FileUtilsTest.class);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.utils.FileUtils#getExtension(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetExtension() {
		String fileExtention = FileUtils
				.getExtension(fullyQualifiedFilenameOnUnix);
		logger.debug("fileExtention: {}", fileExtention);

		fileExtention = FileUtils.getExtension(fullyQualifiedFilenameOnWindows);
		logger.debug("fileExtention: {}", fileExtention);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.utils.FileUtils#getFilename(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetFilename() {
		String filename = FileUtils.getFilename(fullyQualifiedFilenameOnUnix);
		logger.debug("filename: {}", filename);

		filename = FileUtils.getFilename(fullyQualifiedFilenameOnWindows);
		logger.debug("filename: {}", filename);
	}

}
