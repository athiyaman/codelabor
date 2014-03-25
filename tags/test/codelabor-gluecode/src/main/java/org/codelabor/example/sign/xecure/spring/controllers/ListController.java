package org.codelabor.example.sign.xecure.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.sign.dtos.SignDTO;
import org.springframework.web.servlet.ModelAndView;

public class ListController extends BaseSignController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SignDTO> signDTOList = signManager.search();
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("signDTOList", signDTOList);
		return mav;
	}
}
