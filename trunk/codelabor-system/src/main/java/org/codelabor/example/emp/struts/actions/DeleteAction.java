package org.codelabor.example.emp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.codelabor.example.emp.managers.EmpManager;
import org.codelabor.system.struts.actions.BaseAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DeleteAction extends BaseAction {

	public DeleteAction() {
		super();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get bean
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		EmpManager empManager = (EmpManager) ctx
				.getBean("exampleEmpEmpManager");

		// execute biz logic
		DynaActionForm intIdArrayForm = (DynaActionForm) form;
		int[] empNoArray = (int[]) intIdArrayForm.get("id");
		int affectedRowCount = empManager.deleteEmpList(empNoArray);

		// set attribute
		request.setAttribute("affectedRowCount", affectedRowCount);

		// forward
		return mapping.findForward("success");
	}
}
