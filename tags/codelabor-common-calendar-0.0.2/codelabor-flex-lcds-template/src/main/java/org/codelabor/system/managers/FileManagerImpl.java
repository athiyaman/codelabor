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

package org.codelabor.system.managers;

import java.util.List;

import org.codelabor.system.RepositoryType;
import org.codelabor.system.daos.FileDAO;
import org.codelabor.system.dtos.FileDTO;

/**
 * @author SangJae Shin
 * 
 */
public class FileManagerImpl extends BaseManagerImpl implements FileManager {

	private FileDAO fileDAO;

	public int deleteFile(int fileId) throws Exception {
		return fileDAO.deleteFile(fileId);
	}

	public int deleteFile(int[] fileIdList) throws Exception {
		return fileDAO.deleteFile(fileIdList);
	}

	public int insertFile(FileDTO fileDTO) throws Exception {
		return fileDAO.insertFile(fileDTO);
	}

	public int insertFile(List<FileDTO> fileDTOList) throws Exception {
		return fileDAO.insertFile(fileDTOList);
	}

	public List<FileDTO> selectFile(RepositoryType repositoryType)
			throws Exception {
		return fileDAO.selectFile(repositoryType);
	}

	public List<FileDTO> selectFile() throws Exception {
		return fileDAO.selectFile();
	}

	public FileDTO selectFile(int fileId) throws Exception {
		return fileDAO.selectFile(fileId);
	}

	public FileDAO getFileDAO() {
		return fileDAO;
	}

	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}

}
