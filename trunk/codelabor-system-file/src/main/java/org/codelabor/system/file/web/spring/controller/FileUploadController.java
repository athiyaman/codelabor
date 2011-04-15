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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.file.util.UploadUtils;
import org.codelabor.system.file.web.spring.command.FileList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import anyframe.common.util.StringUtil;

/**
 * 파일 업로드 Controller
 * 
 * @author Shin Sang-jae
 * 
 */
public class FileUploadController extends BaseFileFormController {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);
	/**
	 * 파일 저장 방식
	 */
	protected RepositoryType repositoryType;
	/**
	 * 파일 저장 경로
	 */
	protected String repositoryPath;

	/**
	 * 파일 저장 방식을 설정한다.
	 * 
	 * @param repositoryType
	 *            파일 저장 방식
	 */
	public void setRepositoryType(String repositoryType) {
		this.repositoryType = RepositoryType.valueOf(repositoryType);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject
	 * (javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return new FileList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.SimpleFormController#doSubmitAction
	 * (java.lang.Object)
	 */
	@Override
	protected void doSubmitAction(Object command) throws Exception {
		FileList fileList = (FileList) command;
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
			fileDTO.setRealFileName(UploadUtils.stripPathInfo(originalFilename));
			if (acceptedRepositoryType == RepositoryType.FILE_SYSTEM) {
				fileDTO.setUniqueFileName(getUniqueFileName());
			}
			fileDTO.setContentType(uploadedFile.getContentType());
			fileDTO.setRepositoryPath(repositoryPath);
			logger.debug(fileDTO.toString());

			UploadUtils.processFile(acceptedRepositoryType,
					uploadedFile.getInputStream(), fileDTO);

			if (fileDTO != null)
				fileManager.insertFile(fileDTO);
		}
		super.doSubmitAction(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.SimpleFormController#showForm(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		Map<String, Object> controlModel = new HashMap<String, Object>();
		return super.showForm(request, response, errors, controlModel);
	}

	/**
	 * 고유 파일명을 가져온다.
	 * 
	 * @return 고유 파일명
	 * @throws Exception
	 *             예외
	 */
	protected String getUniqueFileName() throws Exception {
		return uniqueFileNameGenerationService.getNextStringId();
	}
}
