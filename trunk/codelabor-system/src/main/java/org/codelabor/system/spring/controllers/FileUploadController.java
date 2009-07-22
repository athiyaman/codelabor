package org.codelabor.system.spring.controllers;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.managers.FileManager;
import org.codelabor.system.spring.commands.FileList;
import org.codelabor.system.spring.commands.Post;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public class FileUploadController extends SimpleFormController {
	protected FileManager fileManager;
	protected IPropertiesService propertiesService;
	protected IIdGenerationService uniqueFileNameGenerationService;

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return new FileList();
	}

	@Override
	protected void doSubmitAction(Object command) throws Exception {
		Post postDTO = (Post) command;
		logger.debug("subject: " + postDTO.getSubject());
		logger.debug("description: " + postDTO.getDescription());
		logger.debug("writer: " + postDTO.getWriter());

		List<MultipartFile> uploadedFileList = postDTO.getFile();
		Iterator<MultipartFile> iter = uploadedFileList.iterator();
		while (iter.hasNext()) {
			MultipartFile uploadedFile = iter.next();

			if (uploadedFile.getOriginalFilename().length() == 0)
				continue;

			StringBuffer pathName = new StringBuffer();
			pathName.append(System.getProperty("user.home"));
			pathName.append(System.getProperty("file.separator"));
			pathName.append(uploadedFile.getOriginalFilename());
			logger.debug(pathName.toString());
			File file = new File(pathName.toString());
			FileCopyUtils.copy(uploadedFile.getBytes(), file);
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

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	public void setUniqueFileNameGenerationService(
			IIdGenerationService uniqueFileNameGenerationService) {
		this.uniqueFileNameGenerationService = uniqueFileNameGenerationService;
	}
}
