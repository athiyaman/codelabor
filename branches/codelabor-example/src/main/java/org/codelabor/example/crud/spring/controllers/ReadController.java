package org.codelabor.example.crud.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.crud.dtos.CrudDTO;
import org.springframework.web.servlet.ModelAndView;

public class ReadController extends BaseCrudController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CrudDTO crudDTO = crudService.read(Integer.parseInt(request
				.getParameter("id")));
		ModelAndView mav = new ModelAndView(this.successView);
		mav.addObject("crudDTO", crudDTO);
		return mav;
	}

}
