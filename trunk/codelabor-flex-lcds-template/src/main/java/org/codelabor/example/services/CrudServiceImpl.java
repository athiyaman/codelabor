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

package org.codelabor.example.services;

import java.util.List;
import java.util.Map;

import org.codelabor.example.dtos.CrudDTO;
import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.services.BaseServiceImpl;

/**
 * @author SangJae Shin
 * 
 */
public class CrudServiceImpl extends BaseServiceImpl implements CrudService {

	public int create(CrudDTO crudDTO) throws CommonException {
		int affectedRowCount = 0;
		try {
			String crudId = idGenerationService.getNextStringId();
			crudDTO.setId(crudId);
			affectedRowCount = queryService.create(crudDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource,
					"error.crud.create");
		}
		return affectedRowCount;
	}

	public int delete(String[] crudIdList) throws CommonException {
		int affectedRowCount = 0;
		try {
			String queryId = "example.delete.crud";
			for (String crudId : crudIdList) {
				affectedRowCount += queryService.remove(queryId,
						new Object[] { crudId });
			}
		} catch (Exception e) {
			throw new RollbackCommonException(messageSource,
					"error.crud.delete");
		}
		return affectedRowCount;
	}

	@SuppressWarnings("unchecked")
	public List<Map> list() throws CommonException {
		List<Map> crudMapList = null;
		try {
			String queryId = "example.select.crud.list";
			Object[] param = new Object[] {};
			crudMapList = (List<Map>) queryService.find(queryId, param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource, "error.crud.list");
		}
		return crudMapList;
	}

	@SuppressWarnings("unchecked")
	public List<Map> list(String filed1Pattern) throws CommonException {
		List<Map> crudMapList = null;
		try {
			String queryId = "example.select.crud.list.by.field1";
			Object[] param = new Object[] { filed1Pattern };
			crudMapList = (List<Map>) queryService.find(queryId, param);
		} catch (Exception e) {
			throw new RollbackCommonException(messageSource, "error.crud.list");
		}
		return crudMapList;
	}

	@SuppressWarnings("unchecked")
	public Map read(String crudId) throws CommonException {
		Map crudMap = null;
		try {
			String queryId = "example.select.crud";
			Object[] param = new Object[] { crudId };
			List<Map> crudMapList = (List<Map>) queryService.find(queryId,
					param);
			crudMap = crudMapList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RollbackCommonException(messageSource, "error.crud.read");
		}
		return crudMap;
	}

	public int update(CrudDTO crudDTO) throws CommonException {
		int affectedRowCount = 0;
		try {
			affectedRowCount = queryService.update(crudDTO);
		} catch (Exception e) {
			throw new RollbackCommonException(messageSource,
					"error.crud.update");
		}
		return affectedRowCount;
	}

}
