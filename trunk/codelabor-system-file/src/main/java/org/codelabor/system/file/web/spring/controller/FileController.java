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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.codelabor.system.dto.StringIdArrayDTO;
import org.codelabor.system.file.FileConstants;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.file.exception.InvalidRepositoryTypeException;
import org.codelabor.system.file.manager.FileManager;
import org.codelabor.system.file.util.UploadUtils;
import org.codelabor.system.file.web.spring.command.FileList;
import org.codelabor.system.web.servlet.HttpResponseHeaderConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/download")
	public void download(@RequestHeader("User-Agent") String userAgent,
			@RequestParam("fileId") String fileId, HttpServletResponse response)
			throws Exception {
		StringBuilder stringBuilder = new StringBuilder();

		FileDTO fileDTO;
		fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFilename = fileDTO.getUniqueFilename();
		String realFilename = fileDTO.getRealFilename();
		InputStream inputStream = null;
		if (StringUtil.isNotEmpty(repositoryPath)) {
			// FILE_SYSTEM
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFilename);
			File file = new File(stringBuilder.toString());
			inputStream = new FileInputStream(file);
		} else {
			// DATABASE
			byte[] bytes = new byte[] {};
			if (fileDTO.getFileSize() > 0) {
				bytes = fileDTO.getBytes();
			}
			inputStream = new ByteArrayInputStream(bytes);

		}
		// set response contenttype, header
		String encodedRealFilename = URLEncoder.encode(realFilename, "UTF-8");
		logger.debug("realFilename: {}", realFilename);
		logger.debug("encodedRealFilename: {}", encodedRealFilename);

		response.setContentType(org.codelabor.system.file.FileConstants.CONTENT_TYPE);
		stringBuilder.setLength(0);
		if (userAgent.indexOf("MSIE5.5") > -1) {
			stringBuilder.append("filename=");
		} else {
			stringBuilder.append("attachment; filename=");
		}
		// stringBuilder.append("\"");
		stringBuilder.append(encodedRealFilename);
		// stringBuilder.append("\"");
		response.setHeader(HttpResponseHeaderConstants.CONTENT_DISPOSITION,
				stringBuilder.toString());

		logger.debug("header: {}", stringBuilder.toString());
		logger.debug("character encoding: {}", response.getCharacterEncoding());
		logger.debug("content type: {}", response.getContentType());
		logger.debug("bufferSize: {}", response.getBufferSize());
		logger.debug("locale: {}", response.getLocale());

		BufferedInputStream bufferdInputStream = new BufferedInputStream(
				inputStream);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				servletOutputStream);
		int bytesRead;
		byte buffer[] = new byte[2048];
		while ((bytesRead = bufferdInputStream.read(buffer)) != -1) {
			bufferedOutputStream.write(buffer, 0, bytesRead);
		}
		// flush stream
		bufferedOutputStream.flush();

		// close stream
		inputStream.close();
		bufferdInputStream.close();
		servletOutputStream.close();
		bufferedOutputStream.close();
	}

	@RequestMapping("/view")
	public void view(@RequestParam("fileId") String fileId,
			HttpServletResponse response) throws Exception {
		StringBuilder stringBuilder = null;

		FileDTO fileDTO;
		fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFilename = fileDTO.getUniqueFilename();
		String realFilename = fileDTO.getRealFilename();
		InputStream inputStream = null;
		if (StringUtil.isNotEmpty(repositoryPath)) {
			// FILE_SYSTEM
			stringBuilder = new StringBuilder();
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFilename);
			File file = new File(stringBuilder.toString());
			inputStream = new FileInputStream(file);
		} else {
			// DATABASE
			byte[] bytes = new byte[] {};
			if (fileDTO.getFileSize() > 0) {
				bytes = fileDTO.getBytes();
			}
			inputStream = new ByteArrayInputStream(bytes);

		}
		response.setContentType(fileDTO.getContentType());

		// set response contenttype, header
		String encodedRealFilename = URLEncoder.encode(realFilename, "UTF-8");
		logger.debug("realFilename: {}", realFilename);
		logger.debug("encodedRealFilename: {}", encodedRealFilename);
		logger.debug("character encoding: {}", response.getCharacterEncoding());
		logger.debug("content type: {}", response.getContentType());
		logger.debug("bufferSize: {}", response.getBufferSize());
		logger.debug("locale: {}", response.getLocale());

		BufferedInputStream bufferdInputStream = new BufferedInputStream(
				inputStream);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				servletOutputStream);
		int bytesRead;
		byte buffer[] = new byte[2048];
		while ((bytesRead = bufferdInputStream.read(buffer)) != -1) {
			bufferedOutputStream.write(buffer, 0, bytesRead);
		}
		// flush stream
		bufferedOutputStream.flush();

		// close stream
		inputStream.close();
		bufferdInputStream.close();
		servletOutputStream.close();
		bufferedOutputStream.close();
	}

	@RequestMapping("/list")
	public String list(
			@RequestParam(value = "mapId", required = false) String mapId,
			@RequestParam(value = "repositoryType", required = false) String repositoryType,
			Model model) {
		List<FileDTO> fileDTOList = null;
		try {
			if (StringUtils.isEmpty(repositoryType)) {
				if (StringUtils.isEmpty(mapId)) {
					fileDTOList = fileManager.selectFileAll();
				} else {
					fileDTOList = fileManager.selectFileByMapId(mapId);
				}
			} else {
				switch (RepositoryType.valueOf(repositoryType)) {
				case DATABASE:
					fileDTOList = fileManager
							.selectFileByRepositoryType(RepositoryType.DATABASE);
					break;
				case FILE_SYSTEM:
					fileDTOList = fileManager
							.selectFileByRepositoryType(RepositoryType.FILE_SYSTEM);
					break;
				default:
					logger.error("Invalid repository type: {}", repositoryType);
					throw new InvalidRepositoryTypeException(repositoryType);
				}

			}
			model.addAttribute(FileConstants.FILE_LIST_KEY, fileDTOList);
			model.addAttribute(FileConstants.MAP_ID,
					mapIdGenerationService.getNextStringId());

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return "example.file.spring.mvc.list.definition";
	}

	@RequestMapping("/delete")
	public String delete(StringIdArrayDTO springIDArrayDTO) throws Exception {
		String[] idArray = springIDArrayDTO.getId();
		logger.debug("file id: {}", Arrays.asList(idArray));
		fileManager.deleteFileByFileId(idArray);
		return "redirect:/example/file/spring/mvc/list.do";
	}

}
