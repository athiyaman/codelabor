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

package org.codelabor.system.daos;

import java.util.Collection;
import java.util.List;

import org.codelabor.system.RepositoryType;
import org.codelabor.system.dtos.fieldTO;

/**
 * @author SangJae Shin
 * 
 */
public class FileDAOImpl extends BaseDAOImpl implements FileDAO {

	public int insertFile(fieldTO fieldTO) throws Exception {
		int fileId = idGenerationService.getNextIntegerId();
		if (log.isDebugEnabled()) {
			log.debug("fileId: " + fileId);
		}
		fieldTO.setFileId(fileId);
		return queryService.create(fieldTO);
	}

	public int insertFile(List<fieldTO> insertfieldTOList) throws Exception {
		int fieldTOCount = insertfieldTOList.size();
		int affectedRowCount = 0;
		if (insertfieldTOList != null && insertfieldTOList.size() > 0) {
			for (int i = 0; i < fieldTOCount; i++) {
				affectedRowCount += this.insertFile(insertfieldTOList.get(i));
			}
		}
		return affectedRowCount;
	}

	public int deleteFile(int fileId) throws Exception {
		String queryId = "system.delete.file";
		Object[] param = new Object[] { fileId };
		return queryService.remove(queryId, param);
	}

	public int deleteFile(int[] fileIdList) throws Exception {
		int affectedRowCount = 0;
		for (int fileId : fileIdList) {
			affectedRowCount += this.deleteFile(fileId);
		}
		return affectedRowCount;
	}

	@SuppressWarnings("unchecked")
	public List<fieldTO> selectFile(RepositoryType repositoryType)
			throws Exception {
		String queryId = "system.select.file.list.by.repository.type";
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("REPOSITORY_TYPE=");
		stringBuilder.append(repositoryType.toString());
		Object[] params = new Object[] { stringBuilder.toString() };
		return (List<fieldTO>) queryService.find(queryId, params);
	}

	@SuppressWarnings("unchecked")
	public List<fieldTO> selectFile() throws Exception {
		String queryId = "system.select.file.list";
		Object[] params = new Object[] {};
		return (List<fieldTO>) queryService.find(queryId, params);
	}

	@SuppressWarnings("unchecked")
	public fieldTO selectFile(int fileId) throws Exception {
		String queryId = "system.select.file";
		Object[] param = new Object[] { fileId };
		Collection<fieldTO> fileCol = queryService.find(queryId, param);
		if (fileCol == null || fileCol.size() == 0)
			return null;
		return (fieldTO) fileCol.toArray()[0];
	}
}
