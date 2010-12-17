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
package org.codelabor.system.mime.utils;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TikaMimeDetectUtilsTest {

	private final Logger logger = LoggerFactory
			.getLogger(TikaMimeDetectUtilsTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMimeTypeByteArray() {
		try {
			File file = new File("C:/WINDOWS/clock.avi");
			InputStream inputStream = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			int offset = 0;
			int readCount = 0;
			while (offset < bytes.length
					&& (readCount = inputStream.read(bytes, offset,
							bytes.length - offset)) >= 0) {
				offset += readCount;
			}

			String mimeType = TikaMimeDetectUtils.getMimeType(bytes);
			logger.debug("file name: {}", file.getName());
			logger.debug("mime type: {}", mimeType);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetMimeTypeFile() {
		try {
			File file = new File("C:/WINDOWS/NOTEPAD.EXE");
			String mimeType = TikaMimeDetectUtils.getMimeType(file);
			logger.debug("file name: {}", file.getName());
			logger.debug("mime type: {}", mimeType);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetMimeTypeInputStream() {
		try {
			File file = new File("C:/WINDOWS/twain.dll");
			InputStream inputStream = new FileInputStream(file);
			String mimeType = TikaMimeDetectUtils.getMimeType(inputStream);
			logger.debug("file name: {}", file.getName());
			logger.debug("mime type: {}", mimeType);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetMimeTypeString() {
		try {
			String path = "C:/WINDOWS/SSDM.chm";
			String mimeType = TikaMimeDetectUtils.getMimeType(path);
			logger.debug("file name: {}", path);
			logger.debug("mime type: {}", mimeType);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetMimeTypeURL() {
		try {
			URL url = new URL("http://www.google.com/images/logos/ps_logo2.png");
			String mimeType = TikaMimeDetectUtils.getMimeType(url);
			logger.debug("url: {}", url.getPath());
			logger.debug("mime type: {}", mimeType);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
