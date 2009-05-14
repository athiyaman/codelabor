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
import org.codelabor.system.dtos.fieldTO;

/**
 * @author SangJae Shin
 * 
 */
public class FileManagerImpl extends BaseManagerImpl implements FileManager {

	private FileDAO FileDAO;

	public int deleteFile(int fileId) throws Exception {
		return FileDAO.deleteFile(fileId);
	}

	public int deleteFile(int[] fileIdList) throws Exception {
		return FileDAO.deleteFile(fileIdList);
	}

	public int insertFile(fieldTO fieldTO) throws Exception {
		return FileDAO.insertFile(fieldTO);
	}

	public int insertFile(List<fieldTO> fieldTOList) throws Exception {
		return FileDAO.insertFile(fieldTOList);
	}

	public List<fieldTO> selectFile(RepositoryType repositoryType)
			throws Exception {
		return FileDAO.selectFile(repositoryType);
	}

	public List<fieldTO> selectFile() throws Exception {
		return FileDAO.selectFile();
	}

	public fieldTO selectFile(int fileId) throws Exception {
		return FileDAO.selectFile(fileId);
	}

	public FileDAO getFileDAO() {
		return FileDAO;
	}

	public void setFileDAO(FileDAO FileDAO) {
		this.FileDAO = FileDAO;
	}

}
