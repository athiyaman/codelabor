package org.codelabor.example.emp.spring.controllers;

import org.codelabor.example.emp.managers.EmpManager;
import org.springframework.web.servlet.mvc.AbstractCommandController;

public abstract class BaseEmpCommandController extends
		AbstractCommandController {

	protected EmpManager empManager;

	protected String successView;

	public void setEmpManager(EmpManager empManager) {
		this.empManager = empManager;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public String getSuccessView() {
		return successView;
	}

}
