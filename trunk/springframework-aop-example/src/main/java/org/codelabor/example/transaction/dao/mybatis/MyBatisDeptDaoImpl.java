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

import org.codelabor.example.transaction.dao.DeptDao;
import org.codelabor.example.transaction.dto.DeptDto;
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
public class MyBatisDeptDaoImpl implements DeptDao {

	private static final Logger logger = LoggerFactory
			.getLogger(MyBatisDeptDaoImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 *
	 */
	public MyBatisDeptDaoImpl() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.codelabor.example.dept.dao.DeptDao#selectDeptList()
	 */
	@Override
	public List<DeptDto> selectDeptList() {
		String selectQueryId = "selectDeptList";
		List<DeptDto> deptDtoList = sqlSession.selectList(selectQueryId);
		logger.debug("deptDtoList: {}", deptDtoList);
		return deptDtoList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.codelabor.example.dept.dao.DeptDao#selectDept(java.lang.String)
	 */
	@Override
	public DeptDto selectDept(Integer deptNo) {
		String selectQueryId = "selectDept";
		DeptDto deptDto = sqlSession.selectOne(selectQueryId, deptNo);
		logger.debug("deptDto: {}", deptDto);
		return deptDto;
	}

}
