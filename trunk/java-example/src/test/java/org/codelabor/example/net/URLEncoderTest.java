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
package org.codelabor.example.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sangjae
 * 
 */
public class URLEncoderTest extends TestCase {
	Logger logger = LoggerFactory.getLogger(URLEncoderTest.class);

	/**
	 * Test method for
	 * {@link java.net.URLEncoder#encode(java.lang.String, java.lang.String)}.
	 */
	public void testEncodeStringString() {

		try {
			String beforeReplace = "<b>hello, world!</b>";
			String afterReplace = URLEncoder.encode(beforeReplace, "UTF-8");
			logger.debug("beforeReplace: {}", beforeReplace);
			logger.debug("afterReplace: {}", afterReplace);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			fail();
		}

	}

}
