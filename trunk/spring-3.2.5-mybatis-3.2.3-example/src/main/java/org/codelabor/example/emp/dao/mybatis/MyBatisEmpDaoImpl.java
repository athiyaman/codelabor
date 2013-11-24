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

import org.codelabor.example.emp.dao.EmpDao;
import org.codelabor.example.emp.dto.EmpDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Sang Jae Shin
 * 
 */
@Repository
public class MyBatisEmpDaoImpl implements EmpDao {

	private static final Logger logger = LoggerFactory
			.getLogger(MyBatisEmpDaoImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 
	 */
	public MyBatisEmpDaoImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.emp.dao.EmpDao#selectEmpList()
	 */
	@Override
	public List<EmpDto> selectEmpList() {
		String selectQueryId = "exampleSelectEmpList";
		List<EmpDto> empDtoList = sqlSession.selectList(selectQueryId);
		logger.debug("empDtoList: {}", empDtoList);
		return empDtoList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.emp.dao.EmpDao#selectEmpListByDeptNo(java.lang.
	 * Integer)
	 */
	@Override
	public List<EmpDto> selectEmpListByDeptNo(Integer deptNo) {
		String selectQueryId = "exampleSelectEmpListByDeptNo";
		List<EmpDto> empDtoList = sqlSession.selectList(selectQueryId, deptNo);
		logger.debug("empDtoList: {}", empDtoList);
		return empDtoList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.emp.dao.EmpDao#selectEmp(java.lang.String)
	 */
	@Override
	public EmpDto selectEmp(Integer empNo) {
		String selectQueryId = "exampleSelectEmp";
		EmpDto empDto = sqlSession.selectOne(selectQueryId, empNo);
		logger.debug("empDto: {}", empDto);
		return empDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.emp.dao.EmpDao#insertEmp(org.codelabor.example.
	 * emp.dto.EmpDto)
	 */
	@Override
	public int insertEmp(EmpDto empDto) {
		String insertQueryId = "exampleInsertEmp";
		int affectedRowCount = sqlSession.update(insertQueryId, empDto);
		logger.debug("affected row count: {}", affectedRowCount);
		return affectedRowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.emp.dao.EmpDao#updateEmp(org.codelabor.example.
	 * emp.dto.EmpDto)
	 */
	@Override
	public int updateEmp(EmpDto empDto) {
		String updateQueryId = "exampleUpdateEmp";
		int affectedRowCount = sqlSession.update(updateQueryId, empDto);
		logger.debug("affected row count: {}", affectedRowCount);
		return affectedRowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.emp.dao.EmpDao#deleteEmp(java.lang.String)
	 */
	@Override
	public int deleteEmp(Integer empNo) {
		String deleteQueryId = "exampleDeleteEmp";
		int affectedRowCount = sqlSession.delete(deleteQueryId, empNo);
		logger.debug("affected row count: {}", affectedRowCount);
		return affectedRowCount;
	}

}
