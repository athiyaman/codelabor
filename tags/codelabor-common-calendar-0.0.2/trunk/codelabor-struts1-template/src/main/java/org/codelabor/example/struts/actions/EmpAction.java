package org.codelabor.example.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.example.dtos.EmpDTO;
import org.codelabor.example.managers.EmpManager;
import org.codelabor.system.struts.actions.BaseDispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class EmpAction extends BaseDispatchAction {

	public EmpAction() {
		super();
	}

	@SuppressWarnings("unchecked")
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		EmpManager empManager = (EmpManager) ctx.getBean("empManager");

		List empDTOList = empManager.selectEmpList();
		request.setAttribute("empDTOList", empDTOList);
		return mapping.findForward("list");
	}

	public ActionForward read(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		EmpManager empManager = (EmpManager) ctx.getBean("empManager");

		String empNoParam = request.getParameter("empNo");
		int empNo = 0;
		if (empNoParam != null && empNoParam.length() > 0) {
			empNo = Integer.parseInt(empNoParam);
		}
		EmpDTO empDTO = empManager.selectEmp(empNo);
		request.setAttribute("empDTO", empDTO);
		return mapping.findForward("read");
	}
}
