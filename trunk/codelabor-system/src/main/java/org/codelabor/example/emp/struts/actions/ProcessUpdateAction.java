package org.codelabor.example.emp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.example.emp.dtos.EmpDTO;
import org.codelabor.example.emp.managers.EmpManager;
import org.codelabor.system.struts.actions.BaseAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ProcessUpdateAction extends BaseAction {

	public ProcessUpdateAction() {
		super();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		EmpManager empManager = (EmpManager) ctx
				.getBean("exampleEmpEmpManager");

		int empNo = Integer.parseInt(request.getParameter("id"));
		EmpDTO empDTO = empManager.selectEmp(empNo);
		request.setAttribute("empDTO", empDTO);
		return mapping.findForward("success");
	}
}
