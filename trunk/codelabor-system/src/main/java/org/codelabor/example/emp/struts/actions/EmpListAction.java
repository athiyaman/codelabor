package org.codelabor.example.emp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.bind.ServletRequestUtils;

import anyframe.common.Page;

public class EmpListAction extends BaseEmpAction {

	public EmpListAction() {
		super();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int pageIndex = ServletRequestUtils.getIntParameter(request,
				"pageIndex", 1);
		int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize",
				10);
		Page page = empManager.selectEmpList(pageIndex, pageSize);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}
}
