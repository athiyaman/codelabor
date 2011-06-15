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

package org.codelabor.system.file.dao;

import java.util.Collection;
import java.util.List;

import org.anyframe.idgen.IdGenService;
import org.anyframe.query.QueryService;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 파일 DAO 구현 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class FileDAOImpl implements FileDAO {
	/**
	 * 로거
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(FileDAOImpl.class);

	/**
	 * Id 제네레이션 서비스
	 */
	protected IdGenService idGenerationService;

	/**
	 * 쿼리 서비스
	 */
	protected QueryService queryService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#insertFile(org.codelabor.system
	 * .file.dtos.FileDTO)
	 */
	public int insertFile(FileDTO fileDTO) throws Exception {
		String nextId = idGenerationService.getNextStringId();

		logger.debug("fileId: {}", nextId);

		fileDTO.setFileId(String.valueOf(nextId));
		return queryService.create(fileDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.file.daos.FileDAO#insertFile(java.util.List)
	 */
	public int insertFile(List<FileDTO> insertFileDTOList) throws Exception {
		int affectedRowCount = 0;
		if (insertFileDTOList == null)
			return affectedRowCount;
		int fileDTOCount = insertFileDTOList.size();
		if (insertFileDTOList != null && insertFileDTOList.size() > 0) {
			for (int i = 0; i < fileDTOCount; i++) {
				affectedRowCount += this.insertFile(insertFileDTOList.get(i));
			}
		}
		return affectedRowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.file.daos.FileDAO#deleteFile(java.lang.String)
	 */
	public int deleteFile(String fileId) throws Exception {
		String queryId = "system.delete.file";
		Object[] param = new Object[] { fileId };
		return queryService.remove(queryId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#deleteFile(java.lang.String[])
	 */
	public int deleteFile(String[] fileIdList) throws Exception {
		int affectedRowCount = 0;
		for (String fileId : fileIdList) {
			affectedRowCount += this.deleteFile(fileId);
		}
		return affectedRowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#deleteFileByFileId(java.lang.String
	 * )
	 */
	public int deleteFileByFileId(String fileId) throws Exception {
		String queryId = "system.delete.file.by.file.id";
		Object[] param = new Object[] { fileId };
		return queryService.remove(queryId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#deleteFileByFileId(java.lang.String
	 * [])
	 */
	public int deleteFileByFileId(String[] fileIdList) throws Exception {
		int affectedRowCount = 0;
		for (String fileId : fileIdList) {
			affectedRowCount += this.deleteFileByFileId(fileId);
		}
		return affectedRowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#deleteFileByMapId(java.lang.String
	 * )
	 */
	public int deleteFileByMapId(String mapId) throws Exception {
		String queryId = "system.delete.file.by.map.id";
		Object[] param = new Object[] { mapId };
		return queryService.remove(queryId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#deleteFileByMapId(java.lang.String
	 * [])
	 */
	public int deleteFileByMapId(String[] mapIdList) throws Exception {
		int affectedRowCount = 0;
		for (String mapId : mapIdList) {
			affectedRowCount += this.deleteFileByMapId(mapId);
		}
		return affectedRowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.file.daos.FileDAO#deleteAll()
	 */
	public int deleteAll() throws Exception {
		String queryId = "system.delete.file.all";
		Object[] param = new Object[] {};
		return queryService.remove(queryId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#selectFileByRepositoryType(org
	 * .codelabor.system.file.RepositoryType)
	 */
	@SuppressWarnings("unchecked")
	public List<FileDTO> selectFileByRepositoryType(
			RepositoryType repositoryType) throws Exception {
		String queryId = "system.select.file.list.by.repository.type";
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("REPOSITORY_TYPE=");
		stringBuilder.append(repositoryType.toString());
		Object[] params = new Object[] { stringBuilder.toString() };
		return (List<FileDTO>) queryService.find(queryId, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.file.daos.FileDAO#selectFile()
	 */
	@SuppressWarnings("unchecked")
	public List<FileDTO> selectFile() throws Exception {
		String queryId = "system.select.file.list";
		Object[] param = new Object[] {};
		return (List<FileDTO>) queryService.find(queryId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.file.daos.FileDAO#selectFileAll()
	 */
	@SuppressWarnings("unchecked")
	public List<FileDTO> selectFileAll() throws Exception {
		String queryId = "system.select.file.all";
		Object[] param = new Object[] {};
		return (List<FileDTO>) queryService.find(queryId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#selectFileByFileId(java.lang.String
	 * )
	 */
	@SuppressWarnings("unchecked")
	public FileDTO selectFileByFileId(String fileId) throws Exception {
		String queryId = "system.select.file.by.file.id";
		Object[] param = new Object[] { fileId };
		Collection<FileDTO> fileCol = queryService.find(queryId, param);
		if (fileCol == null || fileCol.size() == 0)
			return null;
		return (FileDTO) fileCol.toArray()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.daos.FileDAO#selectFileByMapId(java.lang.String
	 * )
	 */
	@SuppressWarnings("unchecked")
	public List<FileDTO> selectFileByMapId(String mapId) throws Exception {
		String queryId = "system.select.file.list.by.map.id";
		Object[] param = new Object[] { mapId };
		return (List<FileDTO>) queryService.find(queryId, param);
	}

	/**
	 * Id 제네레이션 서비스를 설정한다.
	 * 
	 * @param idGenerationService
	 *            Id 제네레이션 서비스
	 */
	public void setIdGenService(IdGenService idGenerationService) {
		this.idGenerationService = idGenerationService;
	}

	/**
	 * 쿼리 서비스를 설정한다.
	 * 
	 * @param queryService
	 *            쿼리 서비스
	 */
	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

}
