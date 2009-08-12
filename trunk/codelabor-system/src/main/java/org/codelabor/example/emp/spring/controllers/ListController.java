package org.codelabor.example.emp.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.emp.dtos.EmpDTO;
import org.springframework.web.servlet.ModelAndView;

public class ListController extends BaseEmpController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<EmpDTO> empDTOList = empManager.selectEmpList();
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("empDTOList", empDTOList);
		return mav;
	}

}
