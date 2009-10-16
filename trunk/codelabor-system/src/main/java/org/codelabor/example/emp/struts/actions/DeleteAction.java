package org.codelabor.example.emp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class DeleteAction extends BaseEmpAction {

	public DeleteAction() {
		super();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm stringIdArrayForm = (DynaActionForm) form;
		String[] empNoStringArray = (String[]) stringIdArrayForm.get("id");

		int[] empNoIntArray = new int[empNoStringArray.length];
		for (int i = 0; i < empNoStringArray.length; i++) {
			empNoIntArray[i] = Integer.parseInt(empNoStringArray[i]);
		}

		int affectedRowCount = empManager.deleteEmpList(empNoIntArray);
		request.setAttribute("affectedRowCount", affectedRowCount);
		return mapping.findForward("success");
	}
}
