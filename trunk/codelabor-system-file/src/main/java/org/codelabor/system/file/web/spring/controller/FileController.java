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

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.file.manager.FileManager;
import org.codelabor.system.file.util.UploadUtils;
import org.codelabor.system.file.web.spring.command.FileList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IIdGenerationService;

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
	@Inject
	@Named("fileManager")
	protected FileManager fileManager;

	/**
	 * Map Id 제네레이션 서비스
	 */
	@Inject
	@Named("mapIdGenerationService")
	protected IIdGenerationService mapIdGenerationService;
	/**
	 * 고유 파일명 제네레이션 서비스
	 */
	@Inject
	@Named("uniqueFilenameGenerationService")
	protected IIdGenerationService uniqueFilenameGenerationService;

	/**
	 * 파일 저장 경로
	 */
	@Value("#{fileProperties['file.default.real.repository.path']}")
	protected String repositoryPath;

	/**
	 * 파일 저장 방식
	 */
	@Value("#{fileProperties['file.default.real.repository.type']}")
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
				logger.debug("uniqueFilenameGenerationService: {}",
						uniqueFilenameGenerationService);
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

	public String download() {
		String viewName = null;
		return viewName;
	}

	public String view() {
		String viewName = null;
		return viewName;
	}

	public String list() {
		String viewName = null;
		return viewName;
	}

	public String delete() {
		String viewName = null;
		return viewName;
	}

}
