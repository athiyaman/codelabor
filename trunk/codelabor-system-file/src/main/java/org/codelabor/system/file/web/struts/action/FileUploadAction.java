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

import static org.codelabor.system.dao.DAOConstants.AFFECTED_ROW_COUNT;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anyframe.idgen.IdGenService;
import org.anyframe.util.properties.PropertiesService;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.codelabor.system.file.FileConstants;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.file.exception.InvalidRepositoryTypeException;
import org.codelabor.system.file.manager.FileManager;
import org.codelabor.system.file.util.UploadUtils;
import org.codelabor.system.file.web.struts.form.FileUploadForm;
import org.codelabor.system.web.struts.action.BaseDispatchAction;
import org.codelabor.system.web.util.RequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 파일 업로드 Action
 * 
 * @author Shin Sang-jae
 * 
 */
public class FileUploadAction extends BaseDispatchAction {

	/**
	 * 생성자
	 */
	public FileUploadAction() {
		super();

	}

	/**
	 * 파일 목록을 가져온다.</br>파일 목록은
	 * org.codelabor.system.file.FileConstants.FILE_LIST_KEY라는 키로 attribute에
	 * 등록된다. Map Id도 함께 발급하는데 Map Id는
	 * org.codelabor.system.file.FileConstants.MAP_ID라는 키로 attribute에 등록된다.
	 * 
	 * @param mapping
	 *            액션 매핑
	 * @param form
	 *            액션 폼
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @return 액션 포워드
	 * @throws Exception
	 *             예외
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServlet().getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		IdGenService mapIdGenService = (IdGenService) ctx.getBean("sequenceMapIdGenService");

		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap.toString());

		String mapId = (String) paramMap.get("mapId");
		String repositoryType = (String) paramMap.get("repositoryType");

		List<FileDTO> fileDTOList = null;

		if (StringUtils.isEmpty(repositoryType)) {
			if (StringUtils.isEmpty(mapId)) {
				fileDTOList = fileManager.selectFileAll();
			} else {
				fileDTOList = fileManager.selectFileByMapId(mapId);
			}
		} else {
			switch (RepositoryType.valueOf(repositoryType)) {
			case DATABASE:
				fileDTOList = fileManager.selectFileByRepositoryType(RepositoryType.DATABASE);
				break;
			case FILE_SYSTEM:
				fileDTOList = fileManager.selectFileByRepositoryType(RepositoryType.FILE_SYSTEM);
				break;
			default:
				logger.error("Invalid repository type: {}", repositoryType);
				throw new InvalidRepositoryTypeException(repositoryType);
			}
		}
		request.setAttribute(FileConstants.MAP_ID, mapIdGenService.getNextStringId());
		request.setAttribute(FileConstants.FILE_LIST_KEY, fileDTOList);
		return mapping.findForward("list");
	}

	/**
	 * 파일 정보를 가져온다.</br>읽어올 파일의 파일 Id를 파라미터 fileID로 전달하면 해당 파일의 DTO가
	 * org.codelabor.system.file.FileConstants.FILE_KEY라는 키로 attribute에 등록된다.
	 * 
	 * @param mapping
	 *            액션 매핑
	 * @param form
	 *            액션 폼
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @return 액션 포워드
	 * @throws Exception
	 *             예외
	 */
	public ActionForward read(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServlet().getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		String fileId = request.getParameter("fileId");
		FileDTO fileDTO = fileManager.selectFileByFileId(fileId);
		request.setAttribute(FileConstants.FILE_KEY, fileDTO);
		return mapping.findForward("read");
	}

	/**
	 * 파일을 업로드 한다.</br> 파일 외의 데이터와 매핑이 필요할 경우, (예: 게시판) 파라미터로 mapId를 입력 받는다. 파일
	 * 저장 방식은 파라미터 repositoryType으로 지정하며, 그 값은
	 * org.codelabor.system.file.RepositoryType를 따른다.
	 * 
	 * @param mapping
	 *            액션 매핑
	 * @param form
	 *            액션 폼
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @return 액션 포워드
	 * @throws Exception
	 *             예외
	 */
	public ActionForward upload(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServlet().getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		PropertiesService propertiesService = (PropertiesService) ctx.getBean("propertiesService");
		// get parameter
		String repositoryType = request.getParameter("repositoryType");
		if (repositoryType == null) {
			repositoryType = propertiesService.getString("file.default.real.repository.type", "FILE_SYSTEM");
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
		List<FileDTO> fileDTOList = this.saveFile(RepositoryType.valueOf(repositoryType), mapId, formFileList);

		// invoke manager

		int affectedRowCount = fileManager.insertFile(fileDTOList);
		request.setAttribute(AFFECTED_ROW_COUNT, affectedRowCount);

		// forward
		return mapping.findForward("upload");
	}

	/**
	 * 파일을 저장한다.
	 * 
	 * @param repositoryType
	 *            파일 저장 방식
	 * @param mapId
	 *            Map Id
	 * @param formFile
	 *            폼 파일
	 * @return 파일 DTO
	 * @throws Exception
	 *             예외
	 */
	protected FileDTO saveFile(RepositoryType repositoryType, String mapId, FormFile formFile) throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServlet().getServletContext());
		PropertiesService propertiesService = (PropertiesService) ctx.getBean("propertiesService");
		IdGenService uniqueFilenameGenerationService = (IdGenService) ctx.getBean("uniqueFilenameGenerationService");
		// set file properties
		String realFilename = formFile.getFileName();
		int fileSize = formFile.getFileSize();
		String contentType = formFile.getContentType();
		InputStream inputStream = formFile.getInputStream();
		String uniqueFilename = uniqueFilenameGenerationService.getNextStringId();

		// set configuration
		String repositoryPath = propertiesService.getString("file.default.real.repository.path", System.getProperty("user.dir"));

		// set dto
		FileDTO fileDTO = new FileDTO();
		fileDTO.setMapId(mapId);
		fileDTO.setRealFilename(realFilename);
		fileDTO.setUniqueFilename(uniqueFilename);
		fileDTO.setFileSize(fileSize);
		fileDTO.setContentType(contentType);
		fileDTO.setRepositoryPath(repositoryPath);
		logger.debug(fileDTO.toString());

		UploadUtils.processFile(repositoryType, inputStream, fileDTO);
		return fileDTO;
	}

	/**
	 * 파일을 저장한다.
	 * 
	 * @param repositoryType
	 *            파일 저장 방식
	 * @param mapId
	 *            Map Id
	 * @param formFileList
	 *            Form File List
	 * @return 파일 DTO List
	 * @throws Exception
	 *             예외
	 */
	protected List<FileDTO> saveFile(RepositoryType repositoryType, String mapId, List<FormFile> formFileList) throws Exception {
		List<FileDTO> fileDTOList = new ArrayList<FileDTO>();
		Iterator<FormFile> iter = formFileList.iterator();
		while (iter.hasNext()) {
			FormFile formFile = iter.next();
			String realFilename = formFile.getFileName();
			if (realFilename == null || realFilename.length() == 0) {
				continue;
			}
			FileDTO fileDTO = saveFile(repositoryType, mapId, formFile);
			fileDTOList.add(fileDTO);
		}
		return fileDTOList;
	}

	/**
	 * 파일을 삭제한다.</br>삭제할 파일의 파일 Id를 파라미터 fileId로 지정하여 요청한다. 삭제 건수는
	 * org.codelabor.system.daos.AFFECTED_ROW_COUNT라는 키로 attribute에 등록된다.
	 * 
	 * @param mapping
	 *            액션 매핑
	 * @param form
	 *            액션 폼
	 * @param request
	 *            요청
	 * @param args
	 *            응답
	 * @return 액션 포워드
	 * @throws Exception
	 *             예외
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse args) throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServlet().getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		int affectedRowCount = 0;
		if (form != null) {
			FileUploadForm uploadForm = (FileUploadForm) form;
			String[] fileIdList = uploadForm.getFileId();
			affectedRowCount = fileManager.deleteFileByFileId(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT, affectedRowCount);
		}
		return mapping.findForward("delete");
	}

	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServlet().getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");

		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap.toString());

		String fileId = (String) paramMap.get("fileId");

		StringBuilder sb = new StringBuilder();

		FileDTO fileDTO;
		fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFilename = fileDTO.getUniqueFilename();
		String realFilename = fileDTO.getRealFilename();
		InputStream inputStream = null;
		if (StringUtils.isNotEmpty(repositoryPath)) {
			// FILE_SYSTEM
			sb.setLength(0);
			sb.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				sb.append(File.separator);
			}
			sb.append(uniqueFilename);
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
		response.setContentType(fileDTO.getContentType());

		// set response contenttype, header
		String encodedRealFilename = URLEncoder.encode(realFilename, "UTF-8");
		logger.debug("realFilename: {}", realFilename);
		logger.debug("encodedRealFilename: {}", encodedRealFilename);
		logger.debug("character encoding: {}", response.getCharacterEncoding());
		logger.debug("content type: {}", response.getContentType());
		logger.debug("bufferSize: {}", response.getBufferSize());
		logger.debug("locale: {}", response.getLocale());

		BufferedInputStream bufferdInputStream = new BufferedInputStream(inputStream);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(servletOutputStream);
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
