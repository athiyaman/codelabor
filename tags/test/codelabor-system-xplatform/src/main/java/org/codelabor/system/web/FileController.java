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
package org.codelabor.system.file.web.controller.xplatform;

import static org.codelabor.system.web.xplatform.XplatformConstants.OUTPUT_DATA_SET_LIST;
import static org.codelabor.system.web.xplatform.XplatformConstants.OUTPUT_VARIABLE_LIST;
import static org.codelabor.system.web.xplatform.XplatformConstants.VIEW_NAME;
import org.codelabor.system.exception.xplatform.XplatformException;
import org.codelabor.system.util.xplatform.XplatformUtils;

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
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anyframe.idgen.IdGenService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.codelabor.system.dto.StringIdArrayDTO;
import org.codelabor.system.file.FileConstants;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.file.exception.InvalidRepositoryTypeException;
import org.codelabor.system.file.listener.FileUploadProgressListener;
import org.codelabor.system.file.manager.FileManager;
import org.codelabor.system.file.util.UploadUtils;
import org.codelabor.system.file.web.spring.command.FileList;
import org.codelabor.system.web.servlet.HttpResponseHeaderConstants;
import org.codelabor.system.web.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.VariableList;

/**
 * @author Shin Sang-jae
 *
 */
@Controller("xplatformFileController")
@RequestMapping("/system/file/")
public class FileController {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private MessageSource messageSource;
	@Autowired
	@Qualifier("forcedLocale")
	private Locale forcedLocale;
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
	@Named("mapIdGenService")
	protected IdGenService mapIdGenService;
	/**
	 * 고유 파일명 제네레이션 서비스
	 */
	@Inject
	@Named("uniqueFilenameGenerationService")
	protected IdGenService uniqueFilenameGenerationService;

	/**
	 * 파일 저장 경로
	 */
	@Value("#{fileProperties['file.default.real.repository.path']}")
	protected String repositoryPath;

	/**
	 * 메모리 파일 크기 한계치
	 */
	@Value("#{fileProperties['file.default.file.size.threshold']}")
	protected int sizeThreshold;

	/**
	 * 캐릭터 인코딩
	 */
	@Value("#{fileProperties['file.default.character.encoding']}")
	protected String characterEncoding;

	/**
	 * 파일 당 최대 파일 크기
	 */
	@Value("#{fileProperties['file.default.file.size.max']}")
	protected long fileSizeMax;

	/**
	 * 한 요청 당 최대 파일 크기
	 */
	@Value("#{fileProperties['file.default.request.size.max']}")
	protected long requestSizeMax;

	/**
	 * 파일 저장 경로</br>
	 */
	@Value("#{fileProperties['file.default.real.repository.path']}")
	protected String realRepositoryPath;

	/**
	 * 임시 파일 저장 경로
	 */
	@Value("#{fileProperties['file.default.temp.repository.path']}")
	protected String tempRepositoryPath;

	/**
	 * 파일 저장 방식</br>기본 값은 FILE_SYSTEM이다.
	 */
	@Value("#{fileProperties['file.default.real.repository.type']}")
	protected RepositoryType repositoryType;

	@RequestMapping("/upload-test")
	public String upload(Model model, HttpServletRequest request, ServletContext context) throws Exception {
		logger.debug("upload-teset");
		DataSetList outputDataSetList = new DataSetList();
		VariableList outputVariableList = new VariableList();

		try {

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
			logger.debug("paramMap: {}", paramMap.toString());

			String mapId = (String) paramMap.get("mapId");
			RepositoryType acceptedRepositoryType = repositoryType;
			String requestedRepositoryType = (String) paramMap.get("repositoryType");
			if (StringUtils.isNotEmpty(requestedRepositoryType)) {
				acceptedRepositoryType = RepositoryType.valueOf(requestedRepositoryType);
			}

			if (isMultipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(sizeThreshold);
				factory.setRepository(new File(tempRepositoryPath));
				factory.setFileCleaningTracker(FileCleanerCleanup.getFileCleaningTracker(context));

				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(fileSizeMax);
				upload.setSizeMax(requestSizeMax);
				upload.setHeaderEncoding(characterEncoding);
				upload.setProgressListener(new FileUploadProgressListener());

				List<FileItem> fileItemList = upload.parseRequest(request);
				Iterator<FileItem> iter = fileItemList.iterator();

				while (iter.hasNext()) {
					FileItem fileItem = iter.next();
					logger.debug("fileItem: {}", fileItem.toString());
					FileDTO fileDTO = null;
					if (fileItem.isFormField()) {
						paramMap.put(fileItem.getFieldName(), fileItem.getString(characterEncoding));
					} else {
						if (fileItem.getName() == null || fileItem.getName().length() == 0)
							continue;
						// set DTO
						fileDTO = new FileDTO();
						fileDTO.setMapId(mapId);
						fileDTO.setRealFilename(FilenameUtils.getName(fileItem.getName()));
						if (acceptedRepositoryType == RepositoryType.FILE_SYSTEM) {
							fileDTO.setUniqueFilename(uniqueFilenameGenerationService.getNextStringId());
						}
						fileDTO.setContentType(fileItem.getContentType());
						fileDTO.setRepositoryPath(realRepositoryPath);
						logger.debug("fileDTO: {}", fileDTO.toString());
						UploadUtils.processFile(acceptedRepositoryType, fileItem.getInputStream(), fileDTO);
					}
					if (fileDTO != null)
						fileManager.insertFile(fileDTO);
				}
			} else {
			}
			XplatformUtils.setSuccessMessage(messageSource.getMessage("info.success", new Object[] {}, forcedLocale), outputVariableList);
			logger.debug("success");
		} catch (Exception e) {
			logger.error("fail");
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new XplatformException(messageSource.getMessage("error.failure", new Object[] {}, forcedLocale), e);
		}
		model.addAttribute(OUTPUT_DATA_SET_LIST, outputDataSetList);
		model.addAttribute(OUTPUT_VARIABLE_LIST, outputVariableList);
		return VIEW_NAME;

	}

	@RequestMapping("/upload")
	public String upload(Model model, FileList fileList) throws Exception {
		logger.debug("upload");

		List<MultipartFile> uploadedFileList = fileList.getFile();
		Iterator<MultipartFile> iter = uploadedFileList.iterator();

		logger.debug("uploadedFileList: {}", uploadedFileList);

		String mapId = fileList.getMapId();
		RepositoryType acceptedRepositoryType = repositoryType;
		String requestedRepositoryType = fileList.getRepositoryType();
		if (StringUtils.isNotEmpty(requestedRepositoryType)) {
			acceptedRepositoryType = RepositoryType.valueOf(requestedRepositoryType);
		}

		DataSetList outputDataSetList = new DataSetList();
		VariableList outputVariableList = new VariableList();

		try {
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
					logger.debug("uniqueFilenameGenerationService: {}", uniqueFilenameGenerationService);
					fileDTO.setUniqueFilename(uniqueFilenameGenerationService.getNextStringId());
				}
				fileDTO.setContentType(uploadedFile.getContentType());
				fileDTO.setRepositoryPath(repositoryPath);
				logger.debug(fileDTO.toString());

				UploadUtils.processFile(acceptedRepositoryType, uploadedFile.getInputStream(), fileDTO);

				if (fileDTO != null)
					fileManager.insertFile(fileDTO);
			}
			XplatformUtils.setSuccessMessage(messageSource.getMessage("info.success", new Object[] {}, forcedLocale), outputVariableList);
			logger.debug("success");
		} catch (Exception e) {
			logger.error("fail");
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new XplatformException(messageSource.getMessage("error.failure", new Object[] {}, forcedLocale), e);
		}
		model.addAttribute(OUTPUT_DATA_SET_LIST, outputDataSetList);
		model.addAttribute(OUTPUT_VARIABLE_LIST, outputVariableList);
		return VIEW_NAME;
	}

	@RequestMapping("/download")
	public String download(Model model, @RequestHeader("User-Agent") String userAgent, @RequestParam("fileId") String fileId, HttpServletResponse response) throws Exception {
		FileDTO fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFilename = fileDTO.getUniqueFilename();
		String realFilename = fileDTO.getRealFilename();
		InputStream inputStream = null;
		BufferedInputStream bufferdInputStream = null;
		ServletOutputStream servletOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;

		StringBuilder sb = new StringBuilder();

		DataSetList outputDataSetList = new DataSetList();
		VariableList outputVariableList = new VariableList();

		try {

			if (StringUtils.isNotEmpty(repositoryPath)) {
				// FILE_SYSTEM
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
			// set response contenttype, header
			String encodedRealFilename = URLEncoder.encode(realFilename, "UTF-8");
			logger.debug("realFilename: {}", realFilename);
			logger.debug("encodedRealFilename: {}", encodedRealFilename);

			response.setContentType(org.codelabor.system.file.FileConstants.CONTENT_TYPE);
			sb.setLength(0);
			if (userAgent.indexOf("MSIE5.5") > -1) {
				sb.append("filename=");
			} else {
				sb.append("attachment; filename=");
			}
			sb.append(encodedRealFilename);
			response.setHeader(HttpResponseHeaderConstants.CONTENT_DISPOSITION, sb.toString());
			logger.debug("header: {}", sb.toString());
			logger.debug("character encoding: {}", response.getCharacterEncoding());
			logger.debug("content type: {}", response.getContentType());
			logger.debug("bufferSize: {}", response.getBufferSize());
			logger.debug("locale: {}", response.getLocale());

			bufferdInputStream = new BufferedInputStream(inputStream);
			servletOutputStream = response.getOutputStream();
			bufferedOutputStream = new BufferedOutputStream(servletOutputStream);
			int bytesRead;
			byte buffer[] = new byte[2048];
			while ((bytesRead = bufferdInputStream.read(buffer)) != -1) {
				bufferedOutputStream.write(buffer, 0, bytesRead);
			}
			// flush stream
			bufferedOutputStream.flush();

			XplatformUtils.setSuccessMessage(messageSource.getMessage("info.success", new Object[] {}, forcedLocale), outputVariableList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new XplatformException(messageSource.getMessage("error.failure", new Object[] {}, forcedLocale), e);
		} finally {
			// close stream
			inputStream.close();
			bufferdInputStream.close();
			servletOutputStream.close();
			bufferedOutputStream.close();
		}
		model.addAttribute(OUTPUT_DATA_SET_LIST, outputDataSetList);
		model.addAttribute(OUTPUT_VARIABLE_LIST, outputVariableList);
		return VIEW_NAME;

	}

	@RequestMapping("/view")
	public String view(Model model, @RequestParam("fileId") String fileId, HttpServletResponse response) throws Exception {
		StringBuilder stringBuilder = null;

		FileDTO fileDTO;
		fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFilename = fileDTO.getUniqueFilename();
		String realFilename = fileDTO.getRealFilename();
		InputStream inputStream = null;

		BufferedInputStream bufferdInputStream = null;
		ServletOutputStream servletOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;

		DataSetList outputDataSetList = new DataSetList();
		VariableList outputVariableList = new VariableList();
		try {
			if (StringUtils.isNotEmpty(repositoryPath)) {
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

			bufferdInputStream = new BufferedInputStream(inputStream);
			servletOutputStream = response.getOutputStream();
			bufferedOutputStream = new BufferedOutputStream(servletOutputStream);
			int bytesRead;
			byte buffer[] = new byte[2048];
			while ((bytesRead = bufferdInputStream.read(buffer)) != -1) {
				bufferedOutputStream.write(buffer, 0, bytesRead);
			}
			// flush stream
			bufferedOutputStream.flush();

			XplatformUtils.setSuccessMessage(messageSource.getMessage("info.success", new Object[] {}, forcedLocale), outputVariableList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new XplatformException(messageSource.getMessage("error.failure", new Object[] {}, forcedLocale), e);
		} finally {
			// close stream
			inputStream.close();
			bufferdInputStream.close();
			servletOutputStream.close();
			bufferedOutputStream.close();
		}
		model.addAttribute(OUTPUT_DATA_SET_LIST, outputDataSetList);
		model.addAttribute(OUTPUT_VARIABLE_LIST, outputVariableList);
		return VIEW_NAME;

	}

	@RequestMapping("/getMapId")
	public String getMapId(Model model) {
		DataSetList outputDataSetList = new DataSetList();
		VariableList outputVariableList = new VariableList();

		try {
			String mapId = mapIdGenService.getNextStringId();
			outputVariableList.add("mapId", mapId);

			XplatformUtils.setSuccessMessage(messageSource.getMessage("info.success", new Object[] {}, forcedLocale), outputVariableList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new XplatformException(messageSource.getMessage("error.failure", new Object[] {}, forcedLocale), e);
		}
		model.addAttribute(OUTPUT_DATA_SET_LIST, outputDataSetList);
		model.addAttribute(OUTPUT_VARIABLE_LIST, outputVariableList);
		return VIEW_NAME;
	}

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "mapId", required = false) String mapId, @RequestParam(value = "repositoryType", required = false) String repositoryType) {
		List<FileDTO> fileDTOList = null;

		DataSetList outputDataSetList = new DataSetList();
		VariableList outputVariableList = new VariableList();

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
			model.addAttribute(FileConstants.FILE_LIST_KEY, fileDTOList);

			XplatformUtils.setSuccessMessage(messageSource.getMessage("info.success", new Object[] {}, forcedLocale), outputVariableList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new XplatformException(messageSource.getMessage("error.failure", new Object[] {}, forcedLocale), e);
		}
		model.addAttribute(OUTPUT_DATA_SET_LIST, outputDataSetList);
		model.addAttribute(OUTPUT_VARIABLE_LIST, outputVariableList);
		return VIEW_NAME;
	}

	@RequestMapping("/delete")
	public String delete(Model model, StringIdArrayDTO springIDArrayDTO) throws Exception {
		String[] idArray = springIDArrayDTO.getId();
		logger.debug("file id: {}", Arrays.asList(idArray));

		DataSetList outputDataSetList = new DataSetList();
		VariableList outputVariableList = new VariableList();

		try {
			fileManager.deleteFileByFileId(idArray);

			XplatformUtils.setSuccessMessage(messageSource.getMessage("info.success", new Object[] {}, forcedLocale), outputVariableList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new XplatformException(messageSource.getMessage("error.failure", new Object[] {}, forcedLocale), e);
		}
		model.addAttribute(OUTPUT_DATA_SET_LIST, outputDataSetList);
		model.addAttribute(OUTPUT_VARIABLE_LIST, outputVariableList);
		return VIEW_NAME;
	}

}
