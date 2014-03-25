package org.codelabor.example.emp.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.emp.dtos.EmpDTO;
import org.springframework.web.servlet.ModelAndView;

public class ReadController extends BaseEmpController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EmpDTO empDTO = empManager.selectEmp(Integer.parseInt(request
				.getParameter("id")));
		ModelAndView mav = new ModelAndView(this.successView);
		mav.addObject("empDTO", empDTO);
		return mav;
	}

}
