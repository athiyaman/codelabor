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

package org.codelabor.system.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DateUtils 테스트 케이스
 * 
 * @author Shin Sangjae
 * 
 */
public class DateUtilsTest {
	/**
	 * 로거
	 */
	Logger logger = LoggerFactory.getLogger(DateUtilsTest.class);

	@Test
	public void testGetDays() {
		// normal year
		int days = DateUtils.getDays(1900, 1);
		assertEquals(31, days);
		logger.debug("days: {}", days);

		days = DateUtils.getDays(1900, 2);
		assertEquals(28, days);
		logger.debug("days: {}", days);

		days = DateUtils.getDays(1900, 4);
		assertEquals(30, days);
		logger.debug("days: {}", days);

		// leap year
		days = DateUtils.getDays(1980, 1);
		assertEquals(31, days);
		logger.debug("days: {}", days);

		days = DateUtils.getDays(1980, 2);
		assertEquals(29, days);
		logger.debug("days: {}", days);

		days = DateUtils.getDays(1980, 4);
		assertEquals(30, days);
		logger.debug("days: {}", days);

	}
}
