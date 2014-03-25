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
package org.codelabor.example.lang.exception;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-jae
 * 
 */
public class ExceptionUtilsTest {

	private Logger logger = LoggerFactory.getLogger(ExceptionUtilsTest.class);
	private Exception3 exception3 = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Exception1 exception1 = new Exception1("exception1");
		Exception2 exception2 = new Exception2("exception2", exception1);
		exception3 = new Exception3("exception3", exception2);

	}

	/**
	 * Test method for
	 * {@link org.apache.commons.lang.exception.ExceptionUtils#getRootCause(java.lang.Throwable)}
	 * .
	 */
	@Test
	public void testGetRootCause() {
		Throwable rootCause = ExceptionUtils.getRootCause(exception3);
		logger.debug("rootCause: {}", rootCause.toString());
		assertEquals("exception1", rootCause.getMessage());
	}

}
