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
package org.codelabor.example.emp.dao.mybatis;

import java.util.List;

import org.codelabor.example.emp.dto.EmpDto;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sang Jae Shin
 * 
 */
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/applicationContext-root.xml",
		"file:src/main/resources/spring/applicationContext-data.xml",
		"file:src/main/resources/spring/applicationContext-myBatis.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MyBatisEmpDaoImplTest {

	@Autowired
	private MyBatisEmpDaoImpl dao;
	private static Logger logger = LoggerFactory
			.getLogger(MyBatisEmpDaoImplTest.class);

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
		Assert.assertNotNull(dao);
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
	 * {@link org.codelabor.example.emp.dao.mybatis.MyBatisEmpDaoImpl#selectEmpList()}
	 * .
	 */
	@Test
	public final void testSelectEmpList() {
		logger.debug("testSelectEmpList");
		List<EmpDto> empList = dao.selectEmpList();
		logger.debug("empList.size(): {}", empList.size());
		Assert.assertNotNull(empList);
		Assert.assertTrue(empList.size() > 0);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.example.emp.dao.mybatis.MyBatisEmpDaoImpl#selectEmpListByDeptNo(java.lang.Integer)}
	 * .
	 */
	@Test
	public final void testSelectEmpListByDeptNo() {
		List<EmpDto> empList = dao.selectEmpListByDeptNo(10);
		logger.debug("empList.size(): {}", empList.size());
		Assert.assertNotNull(empList);
		Assert.assertTrue(empList.size() > 0);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.example.emp.dao.mybatis.MyBatisEmpDaoImpl#selectEmp(java.lang.String)}
	 * .
	 */
	@Test
	public final void testSelectEmp() {
		EmpDto emp = dao.selectEmp(7369);
		Assert.assertNotNull(emp);
		Assert.assertEquals("SMITH", emp.getEname());
	}

	/**
	 * Test method for
	 * {@link org.codelabor.example.emp.dao.mybatis.MyBatisEmpDaoImpl#insertEmp(org.codelabor.example.emp.dto.EmpDto)}
	 * .
	 */
	@Test
	public final void testInsertEmp() {
		Assert.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.codelabor.example.emp.dao.mybatis.MyBatisEmpDaoImpl#updateEmp(org.codelabor.example.emp.dto.EmpDto)}
	 * .
	 */
	@Test
	public final void testUpdateEmp() {
		Assert.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.codelabor.example.emp.dao.mybatis.MyBatisEmpDaoImpl#deleteEmp(java.lang.String)}
	 * .
	 */
	@Test
	public final void testDeleteEmp() {
		Assert.fail("Not yet implemented"); // TODO
	}

}
