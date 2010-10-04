package org.codelabor.example.sign.xecure.web.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.system.sign.dtos.SignDTO;
import org.codelabor.system.sign.managers.SignManager;
import org.codelabor.system.web.struts.actions.BaseAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ListAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// get bean
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		SignManager signManager = (SignManager) ctx.getBean("signManager");

		// execute biz logic
		List<SignDTO> signDTOList = signManager.search();

		// set attribute
		request.setAttribute("signDTOList", signDTOList);

		// forward
		return mapping.findForward("success");
	}

}
