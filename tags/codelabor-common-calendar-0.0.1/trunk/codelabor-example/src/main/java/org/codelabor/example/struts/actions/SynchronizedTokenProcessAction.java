package org.codelabor.example.struts.actions;

import static org.apache.struts.Globals.TRANSACTION_TOKEN_KEY;
import static org.apache.struts.action.ActionMessages.GLOBAL_MESSAGE;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.codelabor.system.struts.actions.BaseAction;

public class SynchronizedTokenProcessAction extends BaseAction {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		ActionErrors errors = new ActionErrors();
		StringBuilder stringBuilder = null;
		String tokenKey = (String) request.getSession().getAttribute(
				TRANSACTION_TOKEN_KEY);

		boolean valid = isTokenValid(request, true);
		if (valid) {
			logger.debug("Token is valid. Token Key: {}", tokenKey);

			// process something
			logger.debug("process something.");
			DynaActionForm dynaActionForm = (DynaActionForm) form;
			Map requestMap = dynaActionForm.getMap();
			request.setAttribute("field1", requestMap.get("field1"));
			request.setAttribute("field2", requestMap.get("field2"));
			forward = mapping.findForward("success");
		} else {
			logger.debug("Token is invalid. Token Key: {}");
			errors.add(GLOBAL_MESSAGE, new ActionMessage("errors.token"));
			forward = new ActionForward(mapping.getInput());
		}
		// reset token
		logger
				.debug("Reset the saved transaction token in the user's session.");

		resetToken(request);

		if (!errors.isEmpty()) {
			// save token

			logger
					.debug("Save a new transaction token in the user's current session, creating a new session if necessary.");

			saveToken(request);

			// save errors
			saveErrors(request, errors);

		}
		return forward;
	}
}
