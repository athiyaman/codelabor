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
package org.springframework.context.support;

import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sang Jae Shin
 * 
 */
@ContextConfiguration(locations = { "file:src/main/resources/spring/applicationContext-root.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ReloadableResourceBundleMessageSourceTest {

	private static Logger logger = LoggerFactory
			.getLogger(ReloadableResourceBundleMessageSourceTest.class);

	@Autowired
	private MessageSource messageSource;

	/**
	 * Test method for
	 * {@link org.springframework.context.support.AbstractMessageSource#getMessage(java.lang.String, java.lang.Object[], java.lang.String, java.util.Locale)}
	 * .
	 */
	@Test
	public final void testGetMessageStringObjectArrayStringLocale() {
		logger.debug("testGetMessageStringObjectArrayStringLocale");
		String message = messageSource.getMessage("button.create", null,
				Locale.ENGLISH);
		logger.debug(message);
		Assert.assertEquals("Create", message);

		message = messageSource
				.getMessage("button.create", null, Locale.KOREAN);
		logger.debug(message);
		Assert.assertEquals("등록", message);
	}

	/**
	 * Test method for
	 * {@link org.springframework.context.support.AbstractMessageSource#getMessage(java.lang.String, java.lang.Object[], java.util.Locale)}
	 * .
	 */
	@Test
	public final void testGetMessageStringObjectArrayLocale() {
		logger.debug("testGetMessageStringObjectArrayLocale");
		String message = messageSource.getMessage("no.such.message", null,
				"An unknown error occrred", Locale.ENGLISH);
		logger.debug(message);
		Assert.assertEquals("An unknown error occrred", message);

		message = messageSource.getMessage("no.such.message", null,
				"알 수 없는 에러가 발생하였습니다.", Locale.KOREAN);
		logger.debug(message);
		Assert.assertEquals("알 수 없는 에러가 발생하였습니다.", message);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("setUpBeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("tearDownAfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		logger.debug("setUp");
		Assert.assertNotNull(messageSource);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		logger.debug("tearDown");
	}

}
