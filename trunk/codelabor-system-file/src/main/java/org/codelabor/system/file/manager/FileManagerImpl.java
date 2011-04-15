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

package org.codelabor.system.file.manager;

import java.util.List;

import org.codelabor.system.anyframe.manager.BaseManagerImpl;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dao.FileDAO;
import org.codelabor.system.file.dto.FileDTO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * 파일 관리자 구현 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class FileManagerImpl extends BaseManagerImpl implements FileManager,
		InitializingBean {

	FileDAO fileDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.file.managers.FileManager#deleteAll()
	 */
	public int deleteAll() throws Exception {
		return fileDAO.deleteAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#deleteFile(java.lang.String
	 * )
	 */
	@SuppressWarnings("deprecation")
	public int deleteFile(String fileId) throws Exception {
		return fileDAO.deleteFile(fileId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#deleteFile(java.lang.String
	 * [])
	 */
	@SuppressWarnings("deprecation")
	public int deleteFile(String[] fileIdList) throws Exception {
		return fileDAO.deleteFile(fileIdList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#deleteFileByFileId(java
	 * .lang.String)
	 */
	public int deleteFileByFileId(String fileId) throws Exception {
		return fileDAO.deleteFileByFileId(fileId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#deleteFileByFileId(java
	 * .lang.String[])
	 */
	public int deleteFileByFileId(String[] fileIdList) throws Exception {
		return fileDAO.deleteFileByFileId(fileIdList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#deleteFileByMapId(java
	 * .lang.String)
	 */
	public int deleteFileByMapId(String mapId) throws Exception {
		return fileDAO.deleteFileByMapId(mapId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#deleteFileByMapId(java
	 * .lang.String[])
	 */
	public int deleteFileByMapId(String[] mapIdList) throws Exception {
		return fileDAO.deleteFileByMapId(mapIdList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#insertFile(org.codelabor
	 * .system.file.dtos.FileDTO)
	 */
	public int insertFile(FileDTO fileDTO) throws Exception {
		return fileDAO.insertFile(fileDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#insertFile(java.util.List)
	 */
	public int insertFile(List<FileDTO> fileDTOList) throws Exception {
		return fileDAO.insertFile(fileDTOList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#selectFileByRepositoryType
	 * (org.codelabor.system.file.RepositoryType)
	 */
	public List<FileDTO> selectFileByRepositoryType(
			RepositoryType repositoryType) throws Exception {
		return fileDAO.selectFileByRepositoryType(repositoryType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#selectFileByMapId(java
	 * .lang.String)
	 */
	public List<FileDTO> selectFileByMapId(String mapId) throws Exception {
		return fileDAO.selectFileByMapId(mapId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.file.managers.FileManager#selectFileAll()
	 */
	public List<FileDTO> selectFileAll() throws Exception {
		return fileDAO.selectFileAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.file.managers.FileManager#selectFile()
	 */
	@SuppressWarnings("deprecation")
	public List<FileDTO> selectFile() throws Exception {
		return fileDAO.selectFile();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.managers.FileManager#selectFileByFileId(java
	 * .lang.String)
	 */
	public FileDTO selectFileByFileId(String fileId) throws Exception {
		return fileDAO.selectFileByFileId(fileId);
	}

	/**
	 * 파일 DAO를 가져온다.
	 * 
	 * @return 파일 DAO
	 */
	public FileDAO getFileDAO() {
		return fileDAO;
	}

	/**
	 * 파일 DAO를 설정한다.
	 * 
	 * @param fileDAO
	 */
	public void setFileDAO(FileDAO fileDAO) {

		this.fileDAO = fileDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(fileDAO);
	}

}
