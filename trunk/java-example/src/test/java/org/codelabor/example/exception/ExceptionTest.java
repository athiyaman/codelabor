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
package org.codelabor.example.exception;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionTest {
	Logger logger = LoggerFactory.getLogger(ExceptionTest.class);
	FirstException firstException = null;
	SecondException secondException = null;
	ThirdException thirdException = null;

	@Before
	public void setUp() throws Exception {
		firstException = new FirstException();
		secondException = new SecondException(firstException);
		thirdException = new ThirdException(secondException);
	}
	
	@Test
	public void testGetStackTrace1() {
		try {
			if (true) {
				throw thirdException;
			}
		} catch (Exception e) {
			logger.error("exception: {}", e.toString());
			StackTraceElement[] stackTraceElements = e.getStackTrace();
			for (StackTraceElement stackTraceElement : stackTraceElements) {
				logger.debug(stackTraceElement.toString());
			}
		}
	}	

	@Test
	public void testGetCause() {
		try {
			if (true) {
				throw thirdException;
			}
		} catch (Exception e) {
			while (e != null) {
				Exception cause = (Exception) e.getCause();
				logger.debug("cause: {}", cause.toString());
				e = cause;
			}
		}
	}
}
