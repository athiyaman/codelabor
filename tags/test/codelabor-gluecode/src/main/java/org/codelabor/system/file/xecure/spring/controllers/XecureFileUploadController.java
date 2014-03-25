package org.codelabor.system.file.xecure.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

public class XecureFileUploadController extends BaseXecureFileController {

	@SuppressWarnings("unused")
	private final Log log = LogFactory.getLog(XecureFileUploadController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return null;
	}

}
