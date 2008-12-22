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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codelabor.example.dtos.EmpDTO;
import org.codelabor.system.daos.BaseDAOImpl;
import org.codelabor.system.dtos.AffectedRowCountDTO;

/**
 * @author SangJae Shin
 * 
 */
public class EmpDAOImpl extends BaseDAOImpl implements EmpDAO {

	public int insertEmp(EmpDTO empDTO) throws Exception {
		String insertQueryId = "example.insert.emp";
		List<Object> params = new ArrayList<Object>();
		params.add(idGenerationService.getNextIntegerId());
		params.add(empDTO.getEname());
		params.add(empDTO.getJob());
		params.add(empDTO.getMgr());
		params.add(empDTO.getHireDate());
		params.add(empDTO.getSal());
		params.add(empDTO.getComm());
		params.add(empDTO.getDeptNo());
		return queryService.create(insertQueryId, params.toArray());
	}

	public int insertEmp(List<EmpDTO> insertEmpDTOList) throws Exception {
		int empDTOCount = insertEmpDTOList.size();
		int affectedRowCount = 0;
		if (insertEmpDTOList != null && insertEmpDTOList.size() > 0) {
			for (int i = 0; i < empDTOCount; i++) {
				affectedRowCount += this.insertEmp(insertEmpDTOList.get(i));
			}
		}
		return affectedRowCount;
	}

	public int updateEmp(EmpDTO empDTO) throws Exception {
		String updateQueryId = "example.update.emp";
		List<Object> params = new ArrayList<Object>();
		params.add(empDTO.getEname());
		params.add(empDTO.getJob());
		params.add(empDTO.getMgr());
		params.add(empDTO.getHireDate());
		params.add(empDTO.getSal());
		params.add(empDTO.getComm());
		params.add(empDTO.getDeptNo());
		params.add(empDTO.getEmpNo());
		return queryService.update(updateQueryId, params.toArray());
	}

	public int updateEmp(List<EmpDTO> updateEmpDTOList) throws Exception {
		int empDTOCount = updateEmpDTOList.size();
		int affectedRowCount = 0;
		if (updateEmpDTOList != null && updateEmpDTOList.size() > 0) {
			for (int i = 0; i < empDTOCount; i++) {
				affectedRowCount += this.updateEmp(updateEmpDTOList.get(i));
			}
		}
		return affectedRowCount;
	}

	public int deleteEmp(EmpDTO empDTO) throws Exception {
		String deleteQueryId = "example.delete.emp";
		List<Object> params = new ArrayList<Object>();
		params.add(empDTO.getEmpNo());
		return queryService.remove(deleteQueryId, params.toArray());
	}

	public int deleteEmp(List<EmpDTO> deleteEmpDTOList) throws Exception {
		int empDTOCount = deleteEmpDTOList.size();
		int affectedRowCount = 0;
		if (deleteEmpDTOList != null && deleteEmpDTOList.size() > 0) {
			for (int i = 0; i < empDTOCount; i++) {
				affectedRowCount += this.deleteEmp(deleteEmpDTOList.get(i));
			}
		}
		return affectedRowCount;
	}

	@SuppressWarnings("unchecked")
	public List<EmpDTO> selectEmp() throws Exception {
		String selectQueryId = "example.select.emp.list";
		Object[] params = new Object[] {};
		return new ArrayList(queryService.find(selectQueryId, params));
	}

	@SuppressWarnings("unchecked")
	public List selectEmp(Map<String, String> searchCondition) throws Exception {
		log.debug("deptNo: " + searchCondition.get("deptNo"));
		String selectQueryId = "example.select.emp.list.by.dept.no";
		Object[] params = new Object[] { Integer.parseInt(searchCondition
				.get("deptNo")) };
		return new ArrayList(queryService.find(selectQueryId, params));
	}

	public AffectedRowCountDTO saveEmp(List<EmpDTO> insertEmpDTOList,
			List<EmpDTO> updateEmpDTOList, List<EmpDTO> deleteEmpDTOList)
			throws Exception {
		AffectedRowCountDTO affectedRowCountDTO = new AffectedRowCountDTO();
		affectedRowCountDTO.setInsertedRowCount(insertEmp(insertEmpDTOList));
		affectedRowCountDTO.setUpdatedRowCount(updateEmp(updateEmpDTOList));
		affectedRowCountDTO.setDeletedRowCount(deleteEmp(deleteEmpDTOList));

		if (log.isDebugEnabled()) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(affectedRowCountDTO);
			log.debug(stringBuilder.toString());
		}
		return affectedRowCountDTO;
	}

	@SuppressWarnings("unchecked")
	public EmpDTO selectEmp(int empNo) throws Exception {
		log.debug("empNo: " + empNo);
		String selectQueryId = "example.select.emp";
		Object[] params = new Object[] { empNo };
		return ((List<EmpDTO>) queryService.find(selectQueryId, params)).get(0);
	}

}
