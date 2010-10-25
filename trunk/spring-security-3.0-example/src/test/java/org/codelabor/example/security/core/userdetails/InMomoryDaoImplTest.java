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
package org.codelabor.example.security.core.userdetails;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Shin Sangjae
 * 
 */
public class InMomoryDaoImplTest {
	private final Logger logger = LoggerFactory
			.getLogger(InMomoryDaoImplTest.class);
	private ApplicationContext context;
	private final String[] configLocations = new String[] { "classpath:**/applicationContext-inMemoryUserDetailsService.xml" };
	private UserDetailsService userDetailsService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(configLocations, true);
		userDetailsService = (UserDetailsService) context
				.getBean("inMemoryUserDetailsService");
	}

	/**
	 * Test method for
	 * {@link org.springframework.security.core.userdetails.memory.InMemoryDaoImpl#loadUserByUsername(java.lang.String)}
	 * .
	 */
	@Test
	public void testLoadUserByUsername() {
		UserDetails userDetails = userDetailsService
				.loadUserByUsername("bomber");
		logger.debug("userDetails: {}", userDetails);

	}

}
