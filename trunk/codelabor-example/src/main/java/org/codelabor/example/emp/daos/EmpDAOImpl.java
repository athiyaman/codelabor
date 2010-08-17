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

package org.codelabor.example.emp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codelabor.example.emp.dtos.EmpDTO;
import org.codelabor.system.daos.BaseDAOImpl;
import org.codelabor.system.dtos.AffectedRowCountDTO;

import anyframe.common.Page;
import anyframe.core.query.IQueryService;

/**
 * @author Sang Jae Shin
 * 
 */
public class EmpDAOImpl extends BaseDAOImpl implements EmpDAO {
	private int pageUnit = 10;

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

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

	public int updateEmpList(List<EmpDTO> updateEmpDTOList) throws Exception {
		int empDTOCount = updateEmpDTOList.size();
		int affectedRowCount = 0;
		if (updateEmpDTOList != null && updateEmpDTOList.size() > 0) {
			for (int i = 0; i < empDTOCount; i++) {
				affectedRowCount += this.updateEmp(updateEmpDTOList.get(i));
			}
		}
		return affectedRowCount;
	}

	public int deleteEmp(int empNo) throws Exception {
		String deleteQueryId = "example.delete.emp";
		List<Object> params = new ArrayList<Object>();
		params.add(empNo);
		return queryService.remove(deleteQueryId, params.toArray());
	}

	public int deleteEmp(EmpDTO empDTO) throws Exception {
		return this.deleteEmp(empDTO.getEmpNo());
	}

	public int deleteEmpList(int[] empNoArray) throws Exception {
		int affectedRowCount = 0;
		if (empNoArray != null) {
			for (int i = 0; i < empNoArray.length; i++) {
				affectedRowCount += this.deleteEmp(empNoArray[i]);
			}
		}
		return affectedRowCount;
	}

	public int deleteEmpList(List<EmpDTO> deleteEmpDTOList) throws Exception {
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
	public List<EmpDTO> selectEmpList() throws Exception {
		String selectQueryId = "example.select.emp.list";
		Object[] params = new Object[] {};
		return new ArrayList(queryService.find(selectQueryId, params));
	}

	@SuppressWarnings("unchecked")
	public List selectEmp(Map<String, String> searchCondition) throws Exception {
		// TODO customize query
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
		affectedRowCountDTO.setUpdatedRowCount(updateEmpList(updateEmpDTOList));
		affectedRowCountDTO.setDeletedRowCount(deleteEmpList(deleteEmpDTOList));
		logger.debug("affectedRowCountDTO {}", affectedRowCountDTO);
		return affectedRowCountDTO;
	}

	@SuppressWarnings("unchecked")
	public EmpDTO selectEmp(int empNo) throws Exception {
		String selectQueryId = "example.select.emp";
		Object[] params = new Object[] { empNo };
		return ((List<EmpDTO>) queryService.find(selectQueryId, params)).get(0);
	}

	@SuppressWarnings("unchecked")
	public Page selectEmpListByDeptNo(int deptNo, int pageIndex, int pageSize)
			throws Exception {
		String selectQueryId = "example.select.emp.list.by.dept.no";
		Object[] params = new Object[] { deptNo };
		Map resultMap = queryService.findWithRowCount(selectQueryId, params,
				pageIndex, pageSize);
		List resultList = (List) resultMap.get(IQueryService.LIST);
		int totalCount = ((Long) resultMap.get(IQueryService.COUNT)).intValue();
		return new Page(resultList, pageIndex, totalCount, pageUnit, pageSize);
	}

	@SuppressWarnings("unchecked")
	public List<EmpDTO> selectEmpListByDeptNo(int deptNo) throws Exception {
		String selectQueryId = "example.select.emp.list.by.dept.no";
		Object[] params = new Object[] { deptNo };
		return new ArrayList(queryService.find(selectQueryId, params));
	}

	@SuppressWarnings("unchecked")
	public Page selectEmpList(int pageIndex, int pageSize) throws Exception {
		String selectQueryId = "example.select.emp.list";
		Object[] params = new Object[] {};
		Map resultMap = queryService.findWithRowCount(selectQueryId, params,
				pageIndex, pageSize);
		List resultList = (List) resultMap.get(IQueryService.LIST);
		int totalCount = ((Long) resultMap.get(IQueryService.COUNT)).intValue();
		return new Page(resultList, pageIndex, totalCount, pageUnit, pageSize);
	}

}
