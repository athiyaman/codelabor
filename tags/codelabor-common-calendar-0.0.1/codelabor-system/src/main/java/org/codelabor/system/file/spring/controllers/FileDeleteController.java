package org.codelabor.system.file.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.dtos.StringIDArrayDTO;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

public class FileDeleteController extends BaseFileCommandController {

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		StringIDArrayDTO springIDArrayDTO = (StringIDArrayDTO) command;
		String[] idArray = springIDArrayDTO.getId();
		fileManager.deleteFile(idArray);
		return new ModelAndView(getSuccessView());
	}

}
