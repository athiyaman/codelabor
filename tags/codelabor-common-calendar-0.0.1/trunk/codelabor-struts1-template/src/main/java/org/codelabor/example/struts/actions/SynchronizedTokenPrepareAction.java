package org.codelabor.example.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.system.struts.actions.BaseAction;

public class SynchronizedTokenPrepareAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// prepare something
		if (log.isDebugEnabled()) {
			log.debug("Prepare something.");
		}
		if (log.isDebugEnabled()) {
			log
					.debug("Save a new transaction token in the user's current session, creating a new session if necessary.");
		}
		saveToken(request);
		return mapping.findForward("success");
	}
}
