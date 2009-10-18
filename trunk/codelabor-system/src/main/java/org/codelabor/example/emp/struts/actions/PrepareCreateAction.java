package org.codelabor.example.emp.struts.actions;

import java.util.List;
import java.util.Map;

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

public class PrepareCreateAction extends BaseAction {

	public PrepareCreateAction() {
		super();
	}

	@SuppressWarnings("unchecked")
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
		List<EmpDTO> empDTOList = empManager.selectEmpList();

		// get reference data
		Map managerMap = empManager.getManagerMap();

		// set attribute
		request.setAttribute("empDTOList", empDTOList);
		request.setAttribute("managerMap", managerMap);

		// forward
		return mapping.findForward("success");
	}
}
