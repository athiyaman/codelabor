package org.codelabor.example.emp.spring.controllers;

import org.codelabor.example.emp.managers.EmpManager;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class BaseEmpFormController extends SimpleFormController {

	protected EmpManager empManager;
	protected CustomDateEditor customDateEditor;

	public CustomDateEditor getCustomDateEditor() {
		return customDateEditor;
	}

	public void setEmpManager(EmpManager empManager) {
		this.empManager = empManager;
	}

	public void setCustomDateEditor(CustomDateEditor customDateEditor) {
		this.customDateEditor = customDateEditor;
	}

}
