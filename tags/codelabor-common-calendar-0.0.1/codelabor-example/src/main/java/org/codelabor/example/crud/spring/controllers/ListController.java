package org.codelabor.example.crud.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.crud.dtos.CrudDTO;
import org.springframework.web.servlet.ModelAndView;

public class ListController extends BaseCrudController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<CrudDTO> crudDTOList = crudService.list();
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("crudDTOList", crudDTOList);
		return mav;
	}

}
