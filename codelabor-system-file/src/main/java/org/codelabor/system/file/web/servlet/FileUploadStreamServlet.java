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

package org.codelabor.system.file.web.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.file.listener.FileUploadProgressListener;
import org.codelabor.system.file.manager.FileManager;
import org.codelabor.system.file.util.UploadUtils;
import org.codelabor.system.web.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 파일 업로드 스트림 서블릿
 * 
 * @author Shin Sang-jae
 * 
 */
public class FileUploadStreamServlet extends FileUploadServlet {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -5122173090841307836L;
	/**
	 * 로거
	 */
	transient private final Logger logger = LoggerFactory.getLogger(FileUploadStreamServlet.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.web.servlets.FileUploadServlet#upload(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		if (logger.isDebugEnabled()) {
			logger.debug(paramMap.toString());
		}

		String mapId = (String) paramMap.get("mapId");
		RepositoryType acceptedRepositoryType = repositoryType;
		String requestedRepositoryType = (String) paramMap.get("repositoryType");
		if (StringUtils.isNotEmpty(requestedRepositoryType)) {
			acceptedRepositoryType = RepositoryType.valueOf(requestedRepositoryType);
		}

		if (isMultipart) {
			ServletFileUpload upload = new ServletFileUpload();
			upload.setFileSizeMax(fileSizeMax);
			upload.setSizeMax(requestSizeMax);
			upload.setHeaderEncoding(characterEncoding);
			upload.setProgressListener(new FileUploadProgressListener());
			try {
				FileItemIterator iter = upload.getItemIterator(request);

				while (iter.hasNext()) {
					FileItemStream fileItemSteam = iter.next();
					if (logger.isDebugEnabled()) {
						logger.debug(fileItemSteam.toString());
					}
					FileDTO fileDTO = null;
					if (fileItemSteam.isFormField()) {
						paramMap.put(fileItemSteam.getFieldName(), Streams.asString(fileItemSteam.openStream(), characterEncoding));
					} else {
						if (fileItemSteam.getName() == null || fileItemSteam.getName().length() == 0)
							continue;

						// set DTO
						fileDTO = new FileDTO();
						fileDTO.setMapId(mapId);
						fileDTO.setRealFilename(FilenameUtils.getName(fileItemSteam.getName()));
						if (acceptedRepositoryType == RepositoryType.FILE_SYSTEM) {
							fileDTO.setUniqueFilename(getUniqueFilename());
						}
						fileDTO.setContentType(fileItemSteam.getContentType());
						fileDTO.setRepositoryPath(realRepositoryPath);
						if (logger.isDebugEnabled()) {
							logger.debug(fileDTO.toString());
						}
						UploadUtils.processFile(acceptedRepositoryType, fileItemSteam.openStream(), fileDTO);
					}
					if (fileDTO != null)
						fileManager.insertFile(fileDTO);
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		} else {
			paramMap = RequestUtils.getParameterMap(request);
		}
		try {
			processParameters(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		dispatch(request, response, forwardPathUpload);

	}
}
