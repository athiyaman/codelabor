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

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

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
	public void testConstructor() {
		File tempDirectory = new File("/temp");
		tempDirectory.mkdirs();
		File tempFile = new File(tempDirectory, "file.ext");
		try {
			tempFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSeparator() {
		logger.debug("System.getProperty(\"file.separator\"): {}",
				System.getProperty("file.separator"));
		logger.debug("File.separator: {}", File.separator);

		String path1 = "/qwer/qwer/";
		assertTrue(!path1.endsWith(File.separator));
		String path2 = "\\qwer\\qwer\\";
		assertTrue(path2.endsWith(File.separator));
	}

	@Test
	public void testExists() {
		File file = new File("/temp/");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);

	}

	@Test
	public void testMkdir() {
		File file = new File("/temp/dir1/dir1-1/");
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
		File file = new File("/temp/dir2/dir2-1/");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}

		file = new File("/temp/dir3/");
		isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}
	}

	@Test
	public void testMkdir2() {
		File file = new File("\\temp\\dir4\\dir4-1\\");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdir();
			logger.debug("mkdir success: {}", success);
		}
	}

	@Test
	public void testMkdirs2() {
		File file = new File("\\temp\\dir5\\dir5-1\\");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}

		file = new File("\\temp\\dir6\\");
		isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}
	}

	@Test
	public void testMkdir3() {
		File file = new File("/temp\\dir7/dir7-1/");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdir();
			logger.debug("mkdir success: {}", success);
		}
	}

	@Test
	public void testMkdirs3() {
		File file = new File("/temp\\dir8/dir8-1/");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}

		file = new File("/temp\\dir9/");
		isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}
	}

	@Test
	public void testMkdir4() {
		File file = new File("/temp" + File.separator + "dir10/dir10-1/");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdir();
			logger.debug("mkdir success: {}", success);
		}
	}

	@Test
	public void testMkdirs4() {
		File file = new File("/temp" + File.separator + "dir11/dir11-1/");
		boolean isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}

		file = new File("/temp" + File.separator + "dir12/");
		isExists = file.exists();
		logger.debug("file name: {}", file.getName());
		logger.debug("is exists: {}", isExists);
		if (!isExists) {
			boolean success = file.mkdirs();
			logger.debug("mkdirs success: {}", success);
		}
	}
	
	@Test
	public void getTotalSpaceTest() {
		File file = new File(System.getProperty("java.io.tmpdir"));
		String path = file.getPath();
		long totalSpace = file.getTotalSpace();
		logger.debug("path: {}, total space: {} Byte", path, DecimalFormat.getInstance().format(totalSpace));
		logger.debug("path: {}, total space: {} KB", path, DecimalFormat.getInstance().format(totalSpace/1024));
		logger.debug("path: {}, total space: {} MB", path, DecimalFormat.getInstance().format(totalSpace/(1024*1024)));
		logger.debug("path: {}, total space: {} GB", path, DecimalFormat.getInstance().format(totalSpace/(1024*1024*1024)));
	}
	
	@Test
	public void getFreeSpaceTest() {
		File file = new File(System.getProperty("java.io.tmpdir"));
		String path = file.getPath();
		long freeSpace = file.getFreeSpace();
		logger.debug("path: {}, total space: {} Byte", path, DecimalFormat.getInstance().format(freeSpace));
		logger.debug("path: {}, total space: {} KB", path, DecimalFormat.getInstance().format(freeSpace/1024));
		logger.debug("path: {}, total space: {} MB", path, DecimalFormat.getInstance().format(freeSpace/(1024*1024)));
		logger.debug("path: {}, total space: {} GB", path, DecimalFormat.getInstance().format(freeSpace/(1024*1024*1024)));
	}

}
