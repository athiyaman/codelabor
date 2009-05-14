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
import org.codelabor.system.dtos.fieldTO;

/**
 * @author SangJae Shin
 * 
 */
public interface FileManager {

	public int deleteFile(int fileId) throws Exception;

	public int deleteFile(int[] fileIdList) throws Exception;

	public int insertFile(fieldTO fieldTO) throws Exception;

	public int insertFile(List<fieldTO> fieldTOList) throws Exception;

	public List<fieldTO> selectFile() throws Exception;

	public List<fieldTO> selectFile(RepositoryType repositoryType)
			throws Exception;

	public fieldTO selectFile(int fileId) throws Exception;

}
