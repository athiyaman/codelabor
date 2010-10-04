package org.codelabor.example.sign.xecure.web.spring.controllers;

import org.codelabor.system.sign.managers.SignManager;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class BaseSignFormController extends SimpleFormController {

	protected SignManager signManager;

	public void setSignManager(SignManager signManager) {
		this.signManager = signManager;
	}

}
