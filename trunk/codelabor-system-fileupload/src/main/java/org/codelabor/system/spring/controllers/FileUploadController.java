package org.codelabor.system.spring.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.managers.FileManager;
import org.codelabor.system.spring.commands.Post;
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
	protected void doSubmitAction(Object command) throws Exception {
		Post post = (Post) command;

		List<MultipartFile> uploadedFileList = post.getFile();
		Iterator<MultipartFile> iter = uploadedFileList.iterator();
		while (iter.hasNext()) {
			MultipartFile uploadedFile = iter.next();
			if (uploadedFile.getOriginalFilename().length() == 0)
				continue;

			// TODO
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
