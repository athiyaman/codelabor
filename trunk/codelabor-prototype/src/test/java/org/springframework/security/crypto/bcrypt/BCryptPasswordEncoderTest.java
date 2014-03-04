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
package org.springframework.security.crypto.bcrypt;

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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sang Jae Shin
 * 
 */
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/applicationContext-root.xml",
		"file:src/main/resources/spring/applicationContext-myBatis.xml",
		"file:src/test/resources/spring/applicationContext-dataSource.xml",
"file:src/main/resources/spring/applicationContext-security.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BCryptPasswordEncoderTest {

	private static final Logger logger = LoggerFactory
			.getLogger(BCryptPasswordEncoderTest.class);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

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
	 * {@link org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder#encode(java.lang.CharSequence)}
	 * .
	 */
	@Test
	public final void testEncode() {
		CharSequence rawPassword = "1234qwer";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		logger.debug("raw password: {}", rawPassword);
		logger.debug("encodedPassword: {}", encodedPassword);
		logger.debug("encodedPassword.length(): {}", encodedPassword.length());
	}

	/**
	 * Test method for
	 * {@link org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder#matches(java.lang.CharSequence, java.lang.String)}
	 * .
	 */
	@Test
	public final void testMatches() {
		String rawPassword = "1234qwer";
		String encodedPassword = "$2a$10$vzDkEmQ0Vc.AJQED7NGiaemoNBRX3oKcYoPMpNBuxr3Zcrkn9JE8S";
		Assert.assertTrue(passwordEncoder.matches(rawPassword, encodedPassword));
	}

}
