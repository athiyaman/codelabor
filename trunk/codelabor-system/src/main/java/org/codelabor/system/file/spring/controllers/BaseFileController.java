package org.codelabor.system.file.spring.controllers;

import org.codelabor.system.file.managers.FileManager;
import org.springframework.web.servlet.mvc.AbstractController;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public abstract class BaseFileController extends AbstractController {

	protected FileManager fileManager;
	protected IPropertiesService propertiesService;
	protected IIdGenerationService uniqueFileNameGenerationService;
	protected String successView;

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

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

}
