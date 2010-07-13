package org.codelabor.example.crud.spring.controllers;

import org.codelabor.example.crud.services.CrudService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class BaseCrudFormController extends SimpleFormController {

	protected CrudService crudService;

	public void setCrudService(CrudService crudService) {
		this.crudService = crudService;
	}

}
