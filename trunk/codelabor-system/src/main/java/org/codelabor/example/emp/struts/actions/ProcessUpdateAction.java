package org.codelabor.example.emp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.example.emp.dtos.EmpDTO;

public class ProcessUpdateAction extends BaseEmpAction {

	public ProcessUpdateAction() {
		super();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int empNo = Integer.parseInt(request.getParameter("id"));
		EmpDTO empDTO = empManager.selectEmp(empNo);
		request.setAttribute("empDTO", empDTO);
		return mapping.findForward("success");
	}
}
