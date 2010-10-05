package org.codelabor.system.file.xecure.web.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * Xecure 파일 업로드 컨트롤러
 * 
 * @author Shin Sangjae
 * 
 */
public class XecureFileUploadController extends BaseXecureFileController {

	/**
	 * 로거
	 */
	@SuppressWarnings("unused")
	private final Log log = LogFactory.getLog(XecureFileUploadController.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.file.xecure.web.spring.controllers.
	 * BaseXecureFileController
	 * #handleRequestInternal(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return null;
	}

}
