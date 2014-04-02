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

package org.codelabor.example.crud.services;

import java.util.List;

import org.codelabor.example.crud.dtos.CrudDTO;
import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.services.BaseServiceImpl;

/**
 * @author Sang Jae Shin
 * 
 */
public class CrudServiceImpl extends BaseServiceImpl implements CrudService {

	public int create(CrudDTO crudDTO) throws CommonException {
		int affectedRowCount = 0;
		try {
			int crudId = idGenerationService.getNextIntegerId();
			crudDTO.setId(crudId);
			affectedRowCount = queryService.create(crudDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource,
					"error.crud.create", e);
		}
		return affectedRowCount;
	}

	public int delete(int[] crudIdList) throws CommonException {
		int affectedRowCount = 0;
		try {
			String queryId = "example.delete.crud";
			for (int crudId : crudIdList) {
				affectedRowCount += queryService.remove(queryId,
						new Object[] { crudId });
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource,
					"error.crud.delete", e);
		}
		return affectedRowCount;
	}

	@SuppressWarnings("unchecked")
	public List<CrudDTO> list() throws CommonException {
		List<CrudDTO> crudDTOList = null;
		try {
			String queryId = "example.select.crud.list";
			Object[] param = new Object[] {};
			crudDTOList = (List<CrudDTO>) queryService.find(queryId, param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource, "error.crud.list",
					e);
		}
		return crudDTOList;
	}

	@SuppressWarnings("unchecked")
	public List<CrudDTO> list(String field1Pattern) throws CommonException {
		List<CrudDTO> crudDTOList = null;
		try {
			String queryId = "example.select.crud.list.by.field1";
			Object[] param = new Object[] { field1Pattern };
			crudDTOList = (List<CrudDTO>) queryService.find(queryId, param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource, "error.crud.list",
					e);
		}
		return crudDTOList;
	}

	@SuppressWarnings("unchecked")
	public CrudDTO read(int crudId) throws CommonException {
		CrudDTO crudDTO = null;
		try {
			String queryId = "example.select.crud";
			Object[] param = new Object[] { crudId };
			List<CrudDTO> crudDTOList = (List<CrudDTO>) queryService.find(
					queryId, param);
			crudDTO = crudDTOList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource, "error.crud.read",
					e);
		}
		return crudDTO;
	}

	public int update(CrudDTO crudDTO) throws CommonException {
		int affectedRowCount = 0;
		try {
			affectedRowCount = queryService.update(crudDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource,
					"error.crud.update", e);
		}
		return affectedRowCount;
	}

}
