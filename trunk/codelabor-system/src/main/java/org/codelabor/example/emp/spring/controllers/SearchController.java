package org.codelabor.example.emp.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.emp.dtos.EmpDTO;
import org.codelabor.example.emp.dtos.SearchConditionDTO;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

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
		List<EmpDTO> empDTOList = empManager.selectEmpListByDeptNo(deptNo,
				pageIndex, pageSize);
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("empDTOList", empDTOList);
		return mav;
	}

}
