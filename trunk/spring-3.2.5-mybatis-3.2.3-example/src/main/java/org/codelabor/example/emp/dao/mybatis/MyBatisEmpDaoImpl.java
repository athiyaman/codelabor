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
import org.springframework.stereotype.Repository;

/**
 * @author Sang Jae Shin
 * 
 */
@Repository
public class MyBatisEmpDaoImpl implements EmpDao {

	/**
	 * 
	 */
	public MyBatisEmpDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.emp.dao.EmpDao#selectEmpList()
	 */
	@Override
	public List<EmpDto> selectEmpList() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.emp.dao.EmpDao#selectEmp(java.lang.String)
	 */
	@Override
	public EmpDto selectEmp(String empNo) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.emp.dao.EmpDao#deleteEmp(java.lang.String)
	 */
	@Override
	public int deleteEmp(String empNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
