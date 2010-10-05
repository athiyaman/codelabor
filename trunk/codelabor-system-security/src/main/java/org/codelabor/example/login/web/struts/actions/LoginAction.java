package org.codelabor.example.login.web.struts.actions;

/**
 * 로그인 액션
 * 
 * @author Shin Sangjae
 * 
 */
public class LoginAction extends
		org.codelabor.system.login.web.struts.actions.LoginAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.web.struts.actions.LoginAction#isAuthenticated
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	protected boolean isAuthenticated(String userId, String password) {
		return true;
	}
}
