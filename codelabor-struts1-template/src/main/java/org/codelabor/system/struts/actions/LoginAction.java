package org.codelabor.system.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.codelabor.system.Constants;
import org.codelabor.system.dtos.LoginDTO;

public abstract class LoginAction extends BaseDispatchAction {

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		ActionMessages errors = new ActionMessages();

		// retreive data
		String userId = (String) PropertyUtils
				.getSimpleProperty(form, "userId");
		String password = (String) PropertyUtils.getSimpleProperty(form,
				"password");

		// trim parameter
		if ((userId != null) && (userId.length() > 0)) {
			userId = userId.trim();
		}
		if ((password != null) && (password.length() > 0)) {
			password = password.trim();
		}

		// authenticate
		if (!isAuthenticated(userId, password)) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.login.failuer"));
			this.saveErrors(request, errors);
			return (mapping.getInputForward());
		}

		// session object
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserId(userId);
		loginDTO.setIpAddress(request.getRemoteAddr());

		// set attribute
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_LOGIN_INFO_KEY, loginDTO);

		// log
		if (log.isDebugEnabled()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(Constants.SESSION_LOGIN_INFO_KEY).append(": ");
			stringBuilder.append(session
					.getAttribute(Constants.SESSION_LOGIN_INFO_KEY));
			log.debug(stringBuilder.toString());
		}
		return mapping.findForward("processLogin");
	}

	abstract protected boolean isAuthenticated(String userId, String password);

	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return mapping.findForward("processLogout");
	}

	public ActionForward prepare(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("prepareLogin");
	}
}
