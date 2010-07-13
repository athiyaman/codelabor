package org.codelabor.system.file.spring.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.spring.commands.FileList;
import org.codelabor.system.file.utils.UploadUtil;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import anyframe.common.util.StringUtil;

public class FileUploadController extends BaseFileFormController {
	private final Log log = LogFactory.getLog(FileUploadController.class);
	protected RepositoryType repositoryType;
	protected String repositoryPath;

	public void setRepositoryType(String repositoryType) {
		this.repositoryType = RepositoryType.valueOf(repositoryType);
	}

	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return new FileList();
	}

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
			fileDTO.setRealFileName(UploadUtil.stripPathInfo(originalFilename));
			fileDTO.setUniqueFileName(getUniqueFileName());
			fileDTO.setContentType(uploadedFile.getContentType());
			fileDTO.setRepositoryPath(repositoryPath);
			if (log.isDebugEnabled()) {
				log.debug(fileDTO);
			}
			UploadUtil.processFile(acceptedRepositoryType, uploadedFile
					.getInputStream(), fileDTO);

			if (fileDTO != null)
				fileManager.insertFile(fileDTO);
		}
		super.doSubmitAction(command);
	}

	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		Map<String, Object> controlModel = new HashMap<String, Object>();
		return super.showForm(request, response, errors, controlModel);
	}

	protected String getUniqueFileName() throws Exception {
		return uniqueFileNameGenerationService.getNextStringId();
	}
}
