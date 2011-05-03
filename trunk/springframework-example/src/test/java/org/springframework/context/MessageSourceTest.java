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
package org.springframework.context;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext*.xml")
public class MessageSourceTest {
	private Logger logger = LoggerFactory.getLogger(MessageSourceTest.class);

	@Autowired
	private ApplicationContext ctx;
	private MessageSource messageSource;

	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext-messageSource.xml" };
	}

	@Before
	public void setUp() {
		messageSource = (MessageSource) ctx.getBean("messageSource", MessageSource.class);
	}

	@Test
	public void testGetMessage() {
		try {
			// test
			String expectedMessage = "Hello, World!";
			String message = messageSource.getMessage("greeting", null, Locale.ENGLISH);

			// assert
			assertEquals(expectedMessage, message);
			logger.debug(message);

			// test
			expectedMessage = "안녕, 세상아!";
			message = messageSource.getMessage("greeting", null, Locale.KOREAN);

			// assert
			assertEquals(expectedMessage, message);
			logger.debug(message);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetMessageReloadable() {
		try {
			for (int i = 0; i < 10; i++) {
				logger.debug("retry count: {}", i);

				// test
				String message = messageSource.getMessage("greeting", null, null);

				// assert
				logger.debug(message);
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
