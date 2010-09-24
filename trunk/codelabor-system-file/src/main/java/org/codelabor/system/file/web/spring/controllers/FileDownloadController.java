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

package org.codelabor.system.file.web.spring.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.web.servlets.HttpRequestHeader;
import org.codelabor.system.web.servlets.HttpResponseHeader;
import org.codelabor.system.web.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import anyframe.common.util.StringUtil;

/**
 * 파일 다운로드 Controller 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class FileDownloadController extends BaseFileController {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(FileDownloadController.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug(paramMap.toString());

		String fileId = (String) paramMap.get("fileId");

		StringBuilder stringBuilder = null;

		FileDTO fileDTO;
		fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFileName = fileDTO.getUniqueFileName();
		String realFileName = fileDTO.getRealFileName();
		InputStream inputStream = null;
		if (StringUtil.isNotEmpty(repositoryPath)) {
			// FILE_SYSTEM
			stringBuilder = new StringBuilder();
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFileName);
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
		String encodedRealFileName = URLEncoder.encode(realFileName, "UTF-8");
		logger.debug("realFileName: {}", realFileName);
		logger.debug("encodedRealFileName: {}", encodedRealFileName);

		response
				.setContentType(org.codelabor.system.file.FileConstants.CONTENT_TYPE);
		stringBuilder.setLength(0);
		if (request.getHeader(HttpRequestHeader.USER_AGENT).indexOf("MSIE5.5") > -1) {
			stringBuilder.append("filename=");
		} else {
			stringBuilder.append("attachment; filename=");
		}
		// stringBuilder.append("\"");
		stringBuilder.append(encodedRealFileName);
		// stringBuilder.append("\"");
		response.setHeader(HttpResponseHeader.CONTENT_DISPOSITION,
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
		return null;
	}
}
