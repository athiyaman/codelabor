package org.codelabor.example.struts.actions;

import static org.apache.struts.action.ActionMessages.GLOBAL_MESSAGE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.codelabor.example.services.ErrorService;
import org.codelabor.system.struts.actions.BaseDispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ErrorAction extends BaseDispatchAction {

	public ActionForward throwException(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		@SuppressWarnings("unused")
		int someValue = 1 / 0;
		return forward;
	}

	public ActionForward forwardErrorPage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		try {
			@SuppressWarnings("unused")
			int someValue = 1 / 0;
		} catch (Exception e) {
			ActionErrors errors = new ActionErrors();
			errors.add(GLOBAL_MESSAGE, new ActionMessage("errors.example1"));
			errors.add(GLOBAL_MESSAGE, new ActionMessage("errors.example2"));
			errors.add(GLOBAL_MESSAGE, new ActionMessage("errors.example3"));
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
			}
			forward = mapping.findForward("error");
		}
		return forward;
	}

	public ActionForward noRollbackMethod(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		ErrorService errorService = (ErrorService) ctx.getBean("errorService");
		errorService.noRollbackMethod();
		return forward;
	}

	public ActionForward rollbackMethod(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		ErrorService errorService = (ErrorService) ctx.getBean("errorService");
		errorService.rollbackMethod();
		return forward;
	}
}
