package org.codelabor.example.emp.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.emp.dtos.SearchConditionDTO;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import anyframe.common.Page;

public class SearchController extends BaseEmpCommandController {
	private int pageSize = 10;

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		SearchConditionDTO searchConditionDTO = (SearchConditionDTO) command;
		int pageIndex = searchConditionDTO.getPageIndex();
		int deptNo = searchConditionDTO.getDeptNo();
		Page page = empManager.selectEmpListByDeptNo(deptNo, pageIndex,
				pageSize);
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("page", page);
		return mav;
	}

}
