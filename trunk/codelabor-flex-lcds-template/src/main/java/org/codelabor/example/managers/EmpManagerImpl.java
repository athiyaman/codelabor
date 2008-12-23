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

package org.codelabor.example.managers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codelabor.example.daos.EmpDAO;
import org.codelabor.example.dtos.EmpDTO;
import org.codelabor.system.managers.BaseManagerImpl;

/**
 * @author SangJae Shin
 * 
 */
public class EmpManagerImpl extends BaseManagerImpl implements EmpManager {

	private EmpDAO empDAO;

	public EmpManagerImpl() {
	}

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	public List<EmpDTO> selectEmpListByDeptNo(int deptNo) throws Exception {
		Map<String, String> searchCondition = new HashMap<String, String>();
		searchCondition.put("deptNo", String.valueOf(deptNo));
		return empDAO.selectEmp(searchCondition);
	}

	public List<EmpDTO> selectEmpList() throws Exception {
		return empDAO.selectEmp();
	}

	public EmpDTO selectEmp(int empNo) throws Exception {
		return empDAO.selectEmp(empNo);
	}
}
