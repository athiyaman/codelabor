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
package org.codelabor.example.lang;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sangjae
 * 
 */
public class StringUtilsTest {
	/**
	 * 로거
	 */
	Logger logger = LoggerFactory.getLogger(StringUtilsTest.class);

	/**
	 * Test method for
	 * {@link org.apache.commons.lang.StringEscapeUtils#escapeHtml(java.lang.String)}
	 * .
	 */
	@Test
	public void testLeftPad() {
		String originalString = "abcd";
		String paddedString = StringUtils.leftPad(originalString, 10, "0");
		logger.debug("originalString: {}", originalString);
		logger.debug("paddedString: {}", paddedString);

		paddedString = StringUtils.leftPad(originalString, 2, "0");
		logger.debug("originalString: {}", originalString);
		logger.debug("paddedString: {}", paddedString);
	}
}
