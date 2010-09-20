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

package org.codelabor.system.file.servlets;

import static org.codelabor.system.daos.DAOConstants.AFFECTED_ROW_COUNT;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.lang.StringUtils;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.listeners.FileUploadProgressListener;
import org.codelabor.system.file.managers.FileManager;
import org.codelabor.system.file.utils.UploadUtils;
import org.codelabor.system.web.servlets.HttpRequestHeader;
import org.codelabor.system.web.servlets.HttpResponseHeader;
import org.codelabor.system.web.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public class FileUploadServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 6060491747750865553L;
	private final static Logger logger = LoggerFactory
			.getLogger(FileUploadServlet.class);

	protected ServletConfig servletConfig;
	protected String parameterName;
	protected String forwardPathUpload;
	protected String forwardPathDownload;
	protected String forwardPathList;
	protected String forwardPathRead;
	protected String forwardPathDelete;
	protected FileCleaningTracker fileCleaningTracker;
	protected FileUploadProgressListener fileUploadProgressListener;

	public enum Parameter {
		upload, download, list, read, delete
	};

	// service
	protected WebApplicationContext ctx;
	protected FileManager fileManager;
	protected IPropertiesService propertiesService;
	protected IIdGenerationService uniqueFileNameGenerationService;
	protected IIdGenerationService mapIdGenerationService;

	// configuration
	protected String characterEncoding = "UTF-8";
	protected int sizeThreshold = DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD;
	protected long fileSizeMax = 1024 * 1024 * 10;
	protected long requestSizeMax = 1024 * 1024 * 100;
	protected String realRepositoryPath = System.getProperty("user.dir");
	protected String tempRepositoryPath = System.getProperty("java.io.tmpdir");
	protected RepositoryType repositoryType = RepositoryType.FILE_SYSTEM;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// get init param
		servletConfig = config;
		parameterName = config.getInitParameter("parameterName");
		forwardPathUpload = config.getInitParameter("forwardPathUpload");
		forwardPathDownload = config.getInitParameter("forwardPathDownload");
		forwardPathList = config.getInitParameter("forwardPathList");
		forwardPathRead = config.getInitParameter("forwardPathRead");
		forwardPathDelete = config.getInitParameter("forwardPathDelete");

		// set service
		ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		fileManager = (FileManager) ctx.getBean("fileManager");
		propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");
		uniqueFileNameGenerationService = (IIdGenerationService) ctx
				.getBean("uniqueFileNameGenerationService");
		mapIdGenerationService = (IIdGenerationService) ctx
				.getBean("sequenceMapIdGenerationService");

		// overwrite configuration
		characterEncoding = propertiesService.getString(
				"file.default.character.encoding", characterEncoding);
		sizeThreshold = propertiesService.getInt(
				"file.default.file.size.threshold", sizeThreshold);
		fileSizeMax = propertiesService.getLong("file.default.file.size.max",
				fileSizeMax);
		requestSizeMax = propertiesService.getLong(
				"file.default.request.size.max", requestSizeMax);
		realRepositoryPath = propertiesService.getString(
				"file.default.real.repository.path", realRepositoryPath);
		tempRepositoryPath = propertiesService.getString(
				"file.default.temp.repository.path", tempRepositoryPath);
		repositoryType = RepositoryType
				.valueOf(propertiesService.getString(
						"file.default.real.repository.type", repositoryType
								.toString()));

		// set file listener / tracker
		fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(config
				.getServletContext());
		fileUploadProgressListener = new FileUploadProgressListener();
	}

	protected String getUniqueFileName() throws Exception {
		return uniqueFileNameGenerationService.getNextStringId();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parameterValue = request.getParameter(parameterName);
			switch (Parameter.valueOf(parameterValue)) {
			case upload:
				upload(request, response);
				break;
			case download:
				download(request, response);
				break;
			case list:
				list(request, response);
				break;
			case delete:
				delete(request, response);
				break;
			case read:
				read(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void processParameters(Map<String, Object> paramMap)
			throws Exception {
		logger.debug("paramMap: {}", paramMap.toString());
	}

	protected void dispatch(HttpServletRequest request,
			HttpServletResponse response, String path) throws Exception {
		logger.debug("dispatch path: ", path);
		RequestDispatcher dispatcher = servletConfig.getServletContext()
				.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void upload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap.toString());

		String mapId = (String) paramMap.get("mapId");
		RepositoryType acceptedRepositoryType = repositoryType;
		String requestedRepositoryType = (String) paramMap
				.get("repositoryType");
		if (StringUtil.isNotEmpty(requestedRepositoryType)) {
			acceptedRepositoryType = RepositoryType
					.valueOf(requestedRepositoryType);
		}

		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(sizeThreshold);
			factory.setRepository(new File(tempRepositoryPath));
			factory.setFileCleaningTracker(fileCleaningTracker);

			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(fileSizeMax);
			upload.setSizeMax(requestSizeMax);
			upload.setHeaderEncoding(characterEncoding);
			upload.setProgressListener(fileUploadProgressListener);
			try {
				List<FileItem> fileItemList = upload.parseRequest(request);
				Iterator<FileItem> iter = fileItemList.iterator();

				while (iter.hasNext()) {
					FileItem fileItem = iter.next();
					logger.debug("fileItem: {}", fileItem.toString());
					FileDTO fileDTO = null;
					if (fileItem.isFormField()) {
						paramMap.put(fileItem.getFieldName(), fileItem
								.getString(characterEncoding));
					} else {
						if (fileItem.getName() == null
								|| fileItem.getName().length() == 0)
							continue;
						// set DTO
						fileDTO = new FileDTO();
						fileDTO.setMapId(mapId);
						fileDTO.setRealFileName(UploadUtils
								.stripPathInfo(fileItem.getName()));
						fileDTO.setUniqueFileName(getUniqueFileName());
						fileDTO.setContentType(fileItem.getContentType());
						fileDTO.setRepositoryPath(realRepositoryPath);
						logger.debug("fileDTO: {}", fileDTO.toString());
						UploadUtils.processFile(acceptedRepositoryType,
								fileItem.getInputStream(), fileDTO);
					}
					if (fileDTO != null)
						fileManager.insertFile(fileDTO);
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			paramMap = RequestUtils.getParameterMap(request);
		}
		try {
			processParameters(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathUpload);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap.toString());

		String mapId = (String) paramMap.get("mapId");
		String repositoryType = (String) paramMap.get("repositoryType");

		List<FileDTO> fileDTOList = null;
		try {
			if (StringUtils.isEmpty(repositoryType)) {
				if (StringUtils.isEmpty(mapId)) {
					fileDTOList = fileManager.selectFile();
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
				}
			}
			request.setAttribute(
					org.codelabor.system.file.FileConstants.FILE_LIST_KEY,
					fileDTOList);
			request.setAttribute(org.codelabor.system.file.FileConstants.MAP_ID,
					mapIdGenerationService.getNextStringId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathList);
	}

	protected void download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap.toString());

		String fileId = (String) paramMap.get("fileId");

		StringBuilder sb = new StringBuilder();

		FileDTO fileDTO;
		fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFileName = fileDTO.getUniqueFileName();
		String realFileName = fileDTO.getRealFileName();
		InputStream inputStream = null;
		if (StringUtil.isNotEmpty(repositoryPath)) {
			// FILE_SYSTEM
			sb.setLength(0);
			sb.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				sb.append(File.separator);
			}
			sb.append(uniqueFileName);
			File file = new File(sb.toString());
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
		sb.setLength(0);
		if (request.getHeader(HttpRequestHeader.USER_AGENT).indexOf("MSIE5.5") > -1) {
			sb.append("filename=");
		} else {
			sb.append("attachment; filename=");
		}
		sb.append(encodedRealFileName);
		response.setHeader(HttpResponseHeader.CONTENT_DISPOSITION, sb
				.toString());

		logger.debug("header: {}", sb.toString());
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

	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int affectedRowCount = 0;
		String[] fileIdList = request.getParameterValues("fileId");
		try {
			affectedRowCount = fileManager.deleteFile(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathDelete);
	}

	protected void read(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fileId = request.getParameter("fileId");
		FileDTO fileDTO = fileManager.selectFileByFileId(fileId);
		request.setAttribute(org.codelabor.system.file.FileConstants.FILE_KEY,
				fileDTO);
		dispatch(request, response, forwardPathRead);
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		return null;
	}
}
