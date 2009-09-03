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

package org.codelabor.example.emp.managers;

import java.util.List;
import java.util.Map;

import org.codelabor.example.emp.dtos.EmpDTO;

import anyframe.common.Page;

/**
 * @author SangJae Shin
 * 
 */
public interface EmpManager {
	public List<EmpDTO> selectEmpList() throws Exception;

	public List<EmpDTO> selectEmpListByDeptNo(int deptNo) throws Exception;

	public EmpDTO selectEmp(int empNo) throws Exception;

	public Page selectEmpListByDeptNo(int deptNo, int pageIndex, int pageSize) throws Exception;

	public int deleteEmp(int empNo) throws Exception;

	public int deleteEmpList(int[] empNoArray) throws Exception;

	public int insertEmp(EmpDTO empDTO) throws Exception;

	public int updateEmp(EmpDTO empDTO) throws Exception;

	public Page selectEmpList(int pageIndex, int pageSize) throws Exception;

	public Map<Integer, String> getManagerMap() throws Exception;
}
