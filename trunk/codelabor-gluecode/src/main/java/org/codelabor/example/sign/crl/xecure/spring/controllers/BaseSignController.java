package org.codelabor.example.sign.crl.xecure.spring.controllers;

import org.codelabor.system.sign.managers.SignManager;
import org.springframework.web.servlet.mvc.AbstractController;

public abstract class BaseSignController extends AbstractController {

	protected SignManager signManager;

	public void setSignManager(SignManager signManager) {
		this.signManager = signManager;
	}

	protected String successView;

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public String getSuccessView() {
		return successView;
	}

}
