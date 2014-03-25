package org.codelabor.example.emp.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import anyframe.common.Page;

public class ListController extends BaseEmpController {

	private int pageSize = 10;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int pageIndex = ServletRequestUtils.getIntParameter(request,
				"pageIndex", 1);

		Page page = empManager.selectEmpList(pageIndex, pageSize);
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("page", page);
		return mav;
	}
}
