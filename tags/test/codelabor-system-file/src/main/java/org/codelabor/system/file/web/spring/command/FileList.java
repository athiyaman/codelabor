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

package org.codelabor.system.file.web.spring.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 파일 List Command
 * 
 * @author Shin Sang-jae
 * 
 */
public class FileList implements Serializable {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -7498417407011918047L;
	/**
	 * 파일 List
	 */
	private List<MultipartFile> file = new ArrayList<MultipartFile>();
	/**
	 * Map Id
	 */
	private String mapId;
	/**
	 * 파일 저장 방식
	 */
	private String repositoryType;

	/**
	 * Map Id를 가져온다.
	 * 
	 * @return Map Id
	 */
	public String getMapId() {
		return mapId;
	}

	/**
	 * Map Id를 설정한다.
	 * 
	 * @param mapId
	 *            Map Id
	 */
	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	/**
	 * 파일 저장 방식을 가져온다.
	 * 
	 * @return 파일 저장 방식
	 */
	public String getRepositoryType() {
		return repositoryType;
	}

	/**
	 * 파일 저장 방식을 설정한다.
	 * 
	 * @param repositoryType
	 *            파일 저장 방식
	 */
	public void setRepositoryType(String repositoryType) {
		this.repositoryType = repositoryType;
	}

	/**
	 * 파일을 가져온다.
	 * 
	 * @return 파일 목록
	 */
	public List<MultipartFile> getFile() {
		return file;
	}

	/**
	 * 파일을 설정한다.
	 * 
	 * @param file
	 *            파일 목록
	 */
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
}
