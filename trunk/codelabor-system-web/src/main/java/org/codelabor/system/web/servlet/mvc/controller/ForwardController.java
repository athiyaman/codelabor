/**
 *
 */
package org.codelabor.system.web.servlet.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 포워드 컨트롤러 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class ForwardController implements Controller {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView(getSuccessView());
	}

	/**
	 * Success 뷰
	 */
	private String successView;

	/**
	 * Success 뷰를 가져온다.
	 * 
	 * @return Success 뷰
	 */
	public String getSuccessView() {
		return successView;
	}

	/**
	 * Success 뷰를 설정한다.
	 * 
	 * @param successView
	 *            Success 뷰
	 */
	public void setSuccessView(String successView) {
		this.successView = successView;
	}

}
