package org.codelabor.example.emp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.example.emp.managers.EmpManager;
import org.codelabor.system.struts.actions.BaseAction;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.common.Page;

public class ListAction extends BaseAction {

	public ListAction() {
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
		int pageIndex = ServletRequestUtils.getIntParameter(request,
				"pageIndex", 1);
		int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize",
				10);
		Page page = empManager.selectEmpList(pageIndex, pageSize);

		// set attribute
		request.setAttribute("page", page);

		// forward
		return mapping.findForward("success");
	}
}
