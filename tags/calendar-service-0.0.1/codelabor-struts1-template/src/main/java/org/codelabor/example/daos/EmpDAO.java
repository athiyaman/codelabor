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

package org.codelabor.example.daos;

import java.util.List;
import java.util.Map;

import org.codelabor.example.dtos.EmpDTO;
import org.codelabor.system.dtos.AffectedRowCountDTO;

/**
 * @author Sang Jae Shin
 * 
 */
public interface EmpDAO {
	public int insertEmp(EmpDTO empDTO) throws Exception;

	public int insertEmp(List<EmpDTO> empDTOList) throws Exception;

	public int updateEmp(EmpDTO empDTO) throws Exception;

	public int updateEmp(List<EmpDTO> empDTOList) throws Exception;

	public int deleteEmp(EmpDTO empDTO) throws Exception;

	public int deleteEmp(List<EmpDTO> empDTOList) throws Exception;

	public AffectedRowCountDTO saveEmp(List<EmpDTO> insertEmpDTOList,
			List<EmpDTO> updateEmpDTOList, List<EmpDTO> deleteEmpDTOList)
			throws Exception;

	public List<EmpDTO> selectEmp() throws Exception;

	public List<EmpDTO> selectEmp(Map<String, String> searchCondition)
			throws Exception;

	public EmpDTO selectEmp(int empNo) throws Exception;
}
