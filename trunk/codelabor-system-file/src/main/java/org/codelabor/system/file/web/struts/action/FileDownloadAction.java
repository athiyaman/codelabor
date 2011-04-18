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

package org.codelabor.system.file.web.struts.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.file.manager.FileManager;
import org.codelabor.system.web.servlet.HttpRequestHeaderConstants;
import org.codelabor.system.web.servlet.HttpResponseHeaderConstants;
import org.codelabor.system.web.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.common.util.StringUtil;

/**
 * 파일 다운로드 Action
 *
 * @author Shin Sang-jae
 *
 */
public class FileDownloadAction extends DownloadAction {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(FileDownloadAction.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.apache.struts.actions.DownloadAction#getStreamInfo(org.apache.struts
	 * .action.ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug(paramMap.toString());

		String fileId = (String) paramMap.get("fileId");

		StringBuilder stringBuilder = null;

		StreamInfo streamInfo = null;
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");

		FileDTO fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFilename = fileDTO.getUniqueFilename();
		String realFileName = fileDTO.getRealFilename();

		// FILE_SYSTEM
		if (StringUtil.isNotEmpty(repositoryPath)) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFilename);
			File file = new File(stringBuilder.toString());
			streamInfo = new FileStreamInfo(
					org.codelabor.system.file.FileConstants.CONTENT_TYPE, file);
			// DATABASE
		} else {
			byte[] bytes = fileDTO.getBytes();
			streamInfo = new ByteArrayStreamInfo(
					org.codelabor.system.file.FileConstants.CONTENT_TYPE, bytes);
		}
		// set response contenttype, header
		String encodedRealFileName = URLEncoder.encode(realFileName, "UTF-8");
		logger.debug("realFileName: {}", realFileName);
		logger.debug("encodedRealFileName: {}", encodedRealFileName);

		response
				.setContentType(org.codelabor.system.file.FileConstants.CONTENT_TYPE);
		stringBuilder.setLength(0);
		if (request.getHeader(HttpRequestHeaderConstants.USER_AGENT).indexOf("MSIE5.5") > -1) {
			stringBuilder.append("filename=");
		} else {
			stringBuilder.append("attachment; filename=");
		}
		// stringBuilder.append("\"");
		stringBuilder.append(encodedRealFileName);
		// stringBuilder.append("\"");
		response.setHeader(HttpResponseHeaderConstants.CONTENT_DISPOSITION,
				stringBuilder.toString());

		logger.debug("header: {}", stringBuilder.toString());
		logger.debug("character encoding: {}", response.getCharacterEncoding());
		logger.debug("content type: {}", response.getContentType());
		logger.debug("bufferSize: {}", response.getBufferSize());
		logger.debug("locale: {}", response.getLocale());
		return streamInfo;
	}

	/**
	 * 바이크 배열 스트림 정보 클래스
	 *
	 * @author Shin Sang-jae
	 *
	 */
	public class ByteArrayStreamInfo implements StreamInfo {
		/**
		 * 컨텐트 타입
		 */
		protected String contentType;

		/**
		 * 바이트 배열
		 */
		protected byte[] bytes;

		/**
		 * 생성자
		 *
		 * @param contentType
		 *            컨탠트 타입
		 * @param bytes
		 *            바이트 배열
		 */
		public ByteArrayStreamInfo(String contentType, byte[] bytes) {
			this.contentType = contentType;
			this.bytes = bytes;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see
		 * org.apache.struts.actions.DownloadAction.StreamInfo#getContentType()
		 */
		public String getContentType() {
			return contentType;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see
		 * org.apache.struts.actions.DownloadAction.StreamInfo#getInputStream()
		 */
		public InputStream getInputStream() throws IOException {
			return new ByteArrayInputStream(bytes);
		}

	}
}
