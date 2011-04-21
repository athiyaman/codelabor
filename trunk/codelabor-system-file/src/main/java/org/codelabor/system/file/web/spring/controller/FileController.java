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
package org.codelabor.system.file.web.spring.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.file.manager.FileManager;
import org.codelabor.system.file.util.UploadUtils;
import org.codelabor.system.file.web.spring.command.FileList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

/**
 * @author Shin Sang-jae
 * 
 */
@Controller
@RequestMapping("/example/file/spring/mvc")
public class FileController {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory.getLogger(FileController.class);
	/**
	 * 파일 매니저
	 */
	protected FileManager fileManager;
	/**
	 * Map Id 제네레이션 서비스
	 */
	protected IIdGenerationService mapIdGenerationService;
	/**
	 * 프러퍼티 서비스
	 */
	protected IPropertiesService propertiesService;
	/**
	 * 고유 파일명 제네레이션 서비스
	 */
	protected IIdGenerationService uniqueFilenameGenerationService;
	/**
	 * 파일 저장 경로
	 */
	protected String repositoryPath;
	/**
	 * 파일 저장 방식
	 */
	protected RepositoryType repositoryType;

	@RequestMapping("upload")
	public String upload(FileList fileList) throws Exception {
		String viewName = "redirect:/example/file/spring/mvc/list.do";

		List<MultipartFile> uploadedFileList = fileList.getFile();
		Iterator<MultipartFile> iter = uploadedFileList.iterator();

		String mapId = fileList.getMapId();
		RepositoryType acceptedRepositoryType = repositoryType;
		String requestedRepositoryType = fileList.getRepositoryType();
		if (StringUtil.isNotEmpty(requestedRepositoryType)) {
			acceptedRepositoryType = RepositoryType
					.valueOf(requestedRepositoryType);
		}

		while (iter.hasNext()) {
			MultipartFile uploadedFile = iter.next();

			String originalFilename = uploadedFile.getOriginalFilename();
			if (originalFilename == null || originalFilename.length() == 0)
				continue;

			// set DTO
			FileDTO fileDTO = new FileDTO();
			fileDTO.setMapId(mapId);
			fileDTO.setRealFilename(FilenameUtils.getName(originalFilename));
			if (acceptedRepositoryType == RepositoryType.FILE_SYSTEM) {
				fileDTO.setUniqueFilename(uniqueFilenameGenerationService
						.getNextStringId());
			}
			fileDTO.setContentType(uploadedFile.getContentType());
			fileDTO.setRepositoryPath(repositoryPath);
			logger.debug(fileDTO.toString());

			UploadUtils.processFile(acceptedRepositoryType,
					uploadedFile.getInputStream(), fileDTO);

			if (fileDTO != null)
				fileManager.insertFile(fileDTO);
		}

		return viewName;
	}

	@RequestMapping("download")
	public String download() {
		String viewName = null;
		return viewName;
	}

	@RequestMapping("view")
	public String view() {
		String viewName = null;
		return viewName;
	}

	@RequestMapping("list")
	public String list() {
		String viewName = null;
		return viewName;
	}

	public String delete() {
		String viewName = null;
		return viewName;
	}

	/**
	 * 파일 매니저를 설정한다.
	 * 
	 * @param fileManager
	 *            파일 매니저
	 */
	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	/**
	 * Map Id 제네레이션 서비스를 설정한다.
	 * 
	 * @param mapIdGenerationService
	 *            Map Id 제네레이션 서비스
	 */
	public void setMapIdGenerationService(
			IIdGenerationService mapIdGenerationService) {
		this.mapIdGenerationService = mapIdGenerationService;
	}

	/**
	 * 프로퍼티 서비스를 설정한다.
	 * 
	 * @param propertiesService
	 *            프로퍼티 서비스
	 */
	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	/**
	 * 고유 파일명 제네레이션 서비스를 설정한다.
	 * 
	 * @param uniqueFilenameGenerationService
	 *            고유 파일명 제네레이션 서비스
	 */
	public void setUniqueFilenameGenerationService(
			IIdGenerationService uniqueFilenameGenerationService) {
		this.uniqueFilenameGenerationService = uniqueFilenameGenerationService;
	}

	/**
	 * 파일 저장 경로를 설정한다.
	 * 
	 * @param repositoryPath
	 *            파일 저장 경로
	 */
	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	/**
	 * 파일 저장 방식을 설정한다.
	 * 
	 * @param repositoryType
	 *            파일 저장 방식
	 */
	public void setRepositoryType(String repositoryType) {
		this.repositoryType = RepositoryType.valueOf(repositoryType);
	}

}
