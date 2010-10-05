package org.codelabor.example.sign.xecure.web.spring.controllers;

import org.codelabor.system.sign.managers.SignManager;
import org.springframework.web.servlet.mvc.AbstractController;

public abstract class BaseSignController extends AbstractController {

	protected SignManager signManager;
	
	protected String successView;	

	public void setSignManager(SignManager signManager) {
		this.signManager = signManager;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public String getSuccessView() {
		return successView;
	}
}
