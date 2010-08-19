package org.codelabor.system.file.spring.controllers;

import org.codelabor.system.file.managers.FileManager;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

@SuppressWarnings("deprecation")
public abstract class BaseFileCommandController extends
		AbstractCommandController {

	protected FileManager fileManager;
	protected IPropertiesService propertiesService;
	protected IIdGenerationService uniqueFileNameGenerationService;
	protected IIdGenerationService mapIdGenerationService;
	protected String successView;

	public void setMapIdGenerationService(
			IIdGenerationService mapIdGenerationService) {
		this.mapIdGenerationService = mapIdGenerationService;
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

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

}
