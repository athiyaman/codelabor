package org.codelabor.system.file.spring.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.spring.commands.FileList;
import org.codelabor.system.file.utils.UploadUtil;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public class FileUploadController extends BaseFileFormController {
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
		while (iter.hasNext()) {
			MultipartFile uploadedFile = iter.next();
			FileDTO fileDTO = UploadUtil.processFile(repositoryType,
					uploadedFile, repositoryPath, getUniqueFileName(), mapId);
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
