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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.codelabor.example.dtos.EmpDTO;

/**
 * @author SangJae Shin
 * 
 */
public class EmpManagerMock implements EmpManager {

	private final List<EmpDTO> empList = new ArrayList<EmpDTO>();

	private void init() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		EmpDTO empDTO1 = new EmpDTO();
		empDTO1.setEmpNo(7369);
		empDTO1.setEname("SMITH");
		empDTO1.setJob("CLERK");
		empDTO1.setMgr(7902);
		calendar.set(1980, 12, 17, 0, 0, 0);
		Timestamp hireDate1 = new Timestamp(calendar.getTimeInMillis());
		empDTO1.setHireDate(hireDate1);
		empDTO1.setSal(800.00f);
		empDTO1.setComm(0.00f);
		empDTO1.setDeptNo(20);
		empList.add(empDTO1);

		EmpDTO empDTO2 = new EmpDTO();
		empDTO2.setEmpNo(7499);
		empDTO2.setEname("ALLEN");
		empDTO2.setJob("SALESMAN");
		empDTO2.setMgr(7698);
		calendar.set(1981, 2, 20, 0, 0, 0);
		Timestamp hireDate2 = new Timestamp(calendar.getTimeInMillis());
		empDTO2.setHireDate(hireDate2);
		empDTO2.setSal(1600.00f);
		empDTO2.setComm(300.00f);
		empDTO2.setDeptNo(30);
		empList.add(empDTO2);

		EmpDTO empDTO3 = new EmpDTO();
		empDTO3.setEmpNo(7521);
		empDTO3.setEname("WARD");
		empDTO3.setJob("SALESMAN");
		empDTO3.setMgr(7698);
		calendar.set(1981, 2, 22, 0, 0, 0);
		Timestamp hireDate3 = new Timestamp(calendar.getTimeInMillis());
		empDTO3.setHireDate(hireDate3);
		empDTO3.setSal(1250.00f);
		empDTO3.setComm(500.00f);
		empDTO3.setDeptNo(30);
		empList.add(empDTO3);
	}

	public EmpManagerMock() {
		init();
	}

	public List<EmpDTO> selectEmpListByDeptNo(int deptNo) throws Exception {
		List<EmpDTO> hittedEmpList = new ArrayList<EmpDTO>();
		for (EmpDTO empDTO : empList) {
			if (deptNo == empDTO.getDeptNo()) {
				hittedEmpList.add(empDTO);
			}
		}
		return hittedEmpList;
	}

	public List<EmpDTO> selectEmpList() throws Exception {
		return empList;
	}

	public EmpDTO selectEmp(int empNo) throws Exception {
		EmpDTO returnEmpDTO = null;
		for (EmpDTO empDTO : empList) {
			if (empNo == empDTO.getEmpNo()) {
				returnEmpDTO = empDTO;
			}
		}
		return returnEmpDTO;
	}
}
