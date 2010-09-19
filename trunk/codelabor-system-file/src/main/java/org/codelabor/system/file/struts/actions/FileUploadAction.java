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

package org.codelabor.system.file.struts.actions;

import static org.codelabor.system.Constants.AFFECTED_ROW_COUNT;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.codelabor.system.file.Constants;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.managers.FileManager;
import org.codelabor.system.file.struts.forms.FileUploadForm;
import org.codelabor.system.file.utils.UploadUtils;
import org.codelabor.system.web.struts.actions.BaseDispatchAction;
import org.codelabor.system.web.utils.RequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public class FileUploadAction extends BaseDispatchAction {

	public FileUploadAction() {
		super();

	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		IIdGenerationService mapIdGenerationService = (IIdGenerationService) ctx
				.getBean("sequenceMapIdGenerationService");

		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap.toString());

		String mapId = (String) paramMap.get("mapId");
		String repositoryType = (String) paramMap.get("repositoryType");

		List<FileDTO> fileDTOList = null;

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
		request.setAttribute(Constants.MAP_ID, mapIdGenerationService
				.getNextStringId());
		request.setAttribute(Constants.FILE_LIST_KEY, fileDTOList);
		return mapping.findForward("list");
	}

	public ActionForward read(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		String fileId = request.getParameter("fileId");
		FileDTO fileDTO = fileManager.selectFileByFileId(fileId);
		request.setAttribute(Constants.FILE_KEY, fileDTO);
		return mapping.findForward("read");
	}

	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		IPropertiesService propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");
		// get parameter
		String repositoryType = request.getParameter("repositoryType");
		if (repositoryType == null) {
			repositoryType = propertiesService.getString(
					"file.default.real.repository.type", "FILE_SYSTEM");
		}
		RepositoryType.valueOf(repositoryType);
		logger.debug("repositoryType: {}", repositoryType);

		// get form
		FileUploadForm uploadForm = (FileUploadForm) form;
		List<FormFile> formFileList = uploadForm.getFormFileList();
		String mapId = uploadForm.getMapId();

		logger.debug("formFileList: {}", formFileList);
		logger.debug("mapId: {}", mapId);

		// upload
		List<FileDTO> fileDTOList = this.saveFile(RepositoryType
				.valueOf(repositoryType), mapId, formFileList);

		// invoke manager

		int affectedRowCount = fileManager.insertFile(fileDTOList);
		request.setAttribute(AFFECTED_ROW_COUNT, affectedRowCount);

		// forward
		return mapping.findForward("upload");
	}

	protected FileDTO saveFile(RepositoryType repositoryType, String mapId,
			FormFile formFile) throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
		IPropertiesService propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");
		IIdGenerationService uniqueFileNameGenerationService = (IIdGenerationService) ctx
				.getBean("uniqueFileNameGenerationService");
		// set file properties
		String realFileName = formFile.getFileName();
		int fileSize = formFile.getFileSize();
		String contentType = formFile.getContentType();
		InputStream inputStream = formFile.getInputStream();
		String uniqueFileName = uniqueFileNameGenerationService
				.getNextStringId();

		// set configuration
		String repositoryPath = propertiesService.getString(
				"file.default.real.repository.path", System
						.getProperty("user.dir"));

		// set dto
		FileDTO fileDTO = new FileDTO();
		fileDTO.setMapId(mapId);
		fileDTO.setRealFileName(realFileName);
		fileDTO.setUniqueFileName(uniqueFileName);
		fileDTO.setFileSize(fileSize);
		fileDTO.setContentType(contentType);
		fileDTO.setRepositoryPath(repositoryPath);
		logger.debug(fileDTO.toString());

		UploadUtils.processFile(repositoryType, inputStream, fileDTO);
		return fileDTO;
	}

	protected List<FileDTO> saveFile(RepositoryType repositoryType,
			String mapId, List<FormFile> formFileList) throws Exception {
		List<FileDTO> fileDTOList = new ArrayList<FileDTO>();
		Iterator<FormFile> iter = formFileList.iterator();
		while (iter.hasNext()) {
			FormFile formFile = iter.next();
			String realFileName = formFile.getFileName();
			if (realFileName == null || realFileName.length() == 0) {
				continue;
			}
			FileDTO fileDTO = saveFile(repositoryType, mapId, formFile);
			fileDTOList.add(fileDTO);
		}
		return fileDTOList;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		int affectedRowCount = 0;
		if (form != null) {
			FileUploadForm uploadForm = (FileUploadForm) form;
			String[] fileIdList = uploadForm.getFileId();
			affectedRowCount = fileManager.deleteFile(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT, affectedRowCount);
		}
		return mapping.findForward("delete");
	}
}
