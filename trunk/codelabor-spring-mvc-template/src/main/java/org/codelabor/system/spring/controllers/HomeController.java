/**
 * 
 */
package org.codelabor.system.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author bomber
 * 
 */
public class HomeController implements Controller {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView(getHomeView());
	}

	private String homeView;

	public String getHomeView() {
		return homeView;
	}

	public void setHomeView(String homeView) {
		this.homeView = homeView;
	}

}
