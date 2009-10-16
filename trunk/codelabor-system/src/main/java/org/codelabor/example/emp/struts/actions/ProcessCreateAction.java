package org.codelabor.example.emp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.example.emp.struts.forms.EmpForm;

public class ProcessCreateAction extends BaseEmpAction {

	public ProcessCreateAction() {
		super();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int affectedRowCount = empManager.insertEmp(((EmpForm) form).toDTO());
		request.setAttribute("affectedRowCount", affectedRowCount);
		return mapping.findForward("success");
	}
}
