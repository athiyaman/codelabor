package org.codelabor.system.login.web.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.codelabor.system.login.dtos.LoginDTO;
import org.codelabor.system.web.SessionConstants;
import org.codelabor.system.web.struts.actions.BaseDispatchAction;

/**
 * 로그인 액션
 * 
 * @author Shin Sangjae
 * 
 */
public abstract class LoginAction extends BaseDispatchAction {

	/**
	 * 로그인한다.
	 * 
	 * @param mapping
	 *            매핑
	 * @param form
	 *            액션 폼
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @return 액션 포워드
	 * @throws Exception
	 *             예외
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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
		session.setAttribute(SessionConstants.SESSION_LOGIN_INFO, loginDTO);

		// log
		logger.debug("session login info {}", session
				.getAttribute(SessionConstants.SESSION_LOGIN_INFO));
		return mapping.findForward("processLogin");
	}

	/**
	 * 로그아웃한다.
	 * 
	 * @param mapping
	 *            매핑
	 * @param form
	 *            액션 폼
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @return 액션 포워드
	 * @throws Exception
	 *             예외
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return mapping.findForward("processLogout");
	}

	/**
	 * 로그인 페이지로 포워딩한다.
	 * 
	 * @param mapping
	 *            매핑
	 * @param form
	 *            폼
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @return 액션 포워드
	 * @throws Exception
	 *             예외
	 */
	public ActionForward prepare(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("prepareLogin");
	}

	/**
	 * 인증 여부를 확인한다.
	 * 
	 * @param userId
	 *            사용자 Id
	 * @param password
	 *            패스워드
	 * @return 인증 여부
	 */
	abstract protected boolean isAuthenticated(String userId, String password);
}
