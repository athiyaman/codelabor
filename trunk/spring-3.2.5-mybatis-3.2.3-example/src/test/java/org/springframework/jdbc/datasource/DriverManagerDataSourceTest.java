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
package org.springframework.jdbc.datasource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sang Jae Shin
 * 
 */
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/applicationContext-root.xml",
		"file:src/main/resources/spring/applicationContext-data.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DriverManagerDataSourceTest {

	private static Logger logger = LoggerFactory
			.getLogger(DriverManagerDataSourceTest.class);

	@Autowired
	private DataSource dataSource;

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
		assertNotNull(dataSource);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		logger.debug("tearDown");
	}

	/**
	 * Test method for
	 * {@link org.springframework.jdbc.datasource.AbstractDriverBasedDataSource#getConnection()}
	 * .
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testGetConnection() throws Exception {
		logger.debug("testGetConnection");
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			assertNotNull(conn);
		} catch (Exception e) {
			logger.error(e.getMessage());
			fail();
		} finally {
			conn.close();
		}
	}

}
