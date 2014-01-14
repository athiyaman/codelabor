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
package org.codelabor.example.transaction.dao.mybatis;

import java.util.List;

import org.codelabor.example.transaction.dao.EmpDao;
import org.codelabor.example.transaction.dto.EmpDto;
import org.codelabor.example.transaction.dto.EmpSearchConditionDto;
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
		String selectQueryId = "selectEmpList";
		List<EmpDto> empDtoList = sqlSession.selectList(selectQueryId);
		logger.debug("empDtoList: {}", empDtoList);
		return empDtoList;
	}

	@Override
	public List<EmpDto> selectEmpListByCondition(
			EmpSearchConditionDto empSearchConditionDto) {
		String selectQueryId = "selectEmpListByCondition";
		logger.debug("empSearchConditionDto: {}", empSearchConditionDto);
		List<EmpDto> empDtoList = sqlSession.selectList(selectQueryId,
				empSearchConditionDto);
		logger.debug("empDtoList: {}", empDtoList);
		return empDtoList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.codelabor.example.emp.dao.EmpDao#selectEmpListByConditionWithPagination
	 * (org.codelabor.example.emp.dto.EmpSearchConditionDto)
	 */
	@Override
	public List<EmpDto> selectEmpListByConditionWithPagination(
			EmpSearchConditionDto empSearchConditionDto) {
		String selectQueryId = "selectEmpListByConditionWithPagination";
		logger.debug("empSearchConditionDto: {}", empSearchConditionDto);
		List<EmpDto> empDtoList = sqlSession.selectList(selectQueryId,
				empSearchConditionDto);
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
		String selectQueryId = "selectEmpListByDeptNo";
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
		String selectQueryId = "selectEmp";
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
		String insertQueryId = "insertEmp";
		logger.debug("empDto: {}", empDto);
		int affectedRowCount = sqlSession.insert(insertQueryId, empDto);
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
		String updateQueryId = "updateEmp";
		logger.debug("empDto: {}", empDto);
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
		String deleteQueryId = "deleteEmp";
		logger.debug("empNo: {}", empNo);
		int affectedRowCount = sqlSession.delete(deleteQueryId, empNo);
		logger.debug("affected row count: {}", affectedRowCount);
		return affectedRowCount;
	}

	@Override
	public int deleteEmpList(List<Integer> empNoList) {
		logger.debug("deleteEmpList: {}", empNoList);
		logger.debug("empNoList: {}", empNoList);
		String deleteQueryId = "deleteEmp";

		// TODO: Batch Update �뚯뒪�명븳 �� ��껜�섍린
		int affectedRowCount = 0;
		for (Integer empNo : empNoList) {
			affectedRowCount += sqlSession.delete(deleteQueryId, empNo);
		}
		logger.debug("affected row count: {}", affectedRowCount);
		return affectedRowCount;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.codelabor.example.emp.dao.EmpDao#getNumberOfRow(org.codelabor.example
	 * .emp.dto.EmpSearchConditionDto)
	 */
	@Override
	public Integer getNumberOfRow(EmpSearchConditionDto empSearchConditionDto) {
		String selectQueryId = "example.emp.getNumberOfRow";
		logger.debug("empSearchConditionDto: {}", empSearchConditionDto);
		Integer numberOfRow = sqlSession.selectOne(selectQueryId,
				empSearchConditionDto);
		logger.debug("numberOfRow: {}", numberOfRow);
		return numberOfRow;
	}

}
