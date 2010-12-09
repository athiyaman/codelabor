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
package org.codelabor.example.io;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTest {
	Logger logger = LoggerFactory.getLogger(FileTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExists() {
		File file = new File("C:/temp");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);

	}

	@Test
	public void testMkdir() {
		File file = new File("C:/temp/dir1/dir1-1");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdir();
			logger.debug("mkdir success: {}", success);
		}
	}

	@Test
	public void testMkdirs() {
		File file = new File("C:/temp/dir2/dir2-1");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}

		file = new File("C:/temp/dir3");
		isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}
	}

}
