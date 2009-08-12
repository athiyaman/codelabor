package org.codelabor.example.emp.spring.controllers;

import org.codelabor.example.emp.managers.EmpManager;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class BaseEmpFormController extends SimpleFormController {

	protected EmpManager empManager;

	public void setEmpManager(EmpManager empManager) {
		this.empManager = empManager;
	}

}
