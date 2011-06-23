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
package org.springframework.beans.factory.config;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author bomber
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext-properties.xml")
public class PropertiesFactoryBeanTeset {

	private Logger logger = LoggerFactory.getLogger(PropertiesFactoryBeanTeset.class);

	@Autowired
	private ApplicationContext ctx;
	private Properties jdbcConfiguration;

	@Before
	public void setUp() {
		jdbcConfiguration = (Properties) ctx.getBean("jdbcConfiguration", Properties.class);
	}

	@Test
	public void getPropertyTest() {
		String databaseProductName = jdbcConfiguration.getProperty("jdbc.database.product");
		logger.debug("databaseProductName: {}", databaseProductName);
		assertEquals("oracle", databaseProductName);
	}
}
