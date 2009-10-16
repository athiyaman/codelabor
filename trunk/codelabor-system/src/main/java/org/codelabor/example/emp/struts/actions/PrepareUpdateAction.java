package org.codelabor.example.emp.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.example.emp.dtos.EmpDTO;

public class PrepareUpdateAction extends BaseEmpAction {

	public PrepareUpdateAction() {
		super();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<EmpDTO> empDTOList = empManager.selectEmpList();
		request.setAttribute("empDTOList", empDTOList);
		return mapping.findForward("success");
	}
}
