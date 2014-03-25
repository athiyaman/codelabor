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
package org.springframework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-jae
 * 
 */
public class ReflectionUtilsTest {
	private Logger logger = LoggerFactory.getLogger(ReflectionUtilsTest.class);

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
	 * {@link org.springframework.util.ReflectionUtils#findField(java.lang.Class, java.lang.String)}
	 * .
	 */
	@Test
	public void testFindFieldClassOfQString() {
		Field field = ReflectionUtils.findField(Calendar.class, "AM");
		logger.debug("field: {}", field);

	}

	/**
	 * Test method for
	 * {@link org.springframework.util.ReflectionUtils#findMethod(java.lang.Class, java.lang.String)}
	 * .
	 */
	@Test
	public void testFindMethodClassOfQString() {
		Method method = ReflectionUtils.findMethod(Calendar.class, "getTime");
		logger.debug("method: {}", method);
	}

}
