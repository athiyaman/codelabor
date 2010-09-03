package org.codelabor.system.security.authorization.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ReloadController extends AbstractController {

	// private AnyframeReloadableDefaultFilterInvocationSecurityMetadataSource
	// securityMetadataSource;
	protected String successView;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// securityMetadataSource.reloadRequestMap();
		ModelAndView mav = new ModelAndView(getSuccessView());
		return mav;
	}

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

}
