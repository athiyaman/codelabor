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

import static org.junit.Assert.assertTrue;

import org.codelabor.system.util.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DateUtils 테스트 케이스
 *
 * @author Shin Sangjae
 *
 */
public class StringUtilsTest {
	/**
	 * 로거
	 */
	Logger logger = LoggerFactory.getLogger(StringUtilsTest.class);

	@Test
	public void testRemoveNonAlphanumeric() {
		String originalString = "!@#$1234QWERASDFqwerasdf가나다라 \t\n\r";
		String removedString = StringUtils
				.removeNonAlphanumeric(originalString);
		assertTrue(org.apache.commons.lang.StringUtils
				.isAlphanumeric(removedString));
	}
}
