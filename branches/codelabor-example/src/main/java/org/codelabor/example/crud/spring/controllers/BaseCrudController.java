package org.codelabor.example.crud.spring.controllers;

import org.codelabor.example.crud.services.CrudService;
import org.springframework.web.servlet.mvc.AbstractController;

public abstract class BaseCrudController extends AbstractController {

	protected CrudService crudService;

	protected String successView;

	public void setCrudService(CrudService crudService) {
		this.crudService = crudService;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public String getSuccessView() {
		return successView;
	}

}
