package org.codelabor.example.login.web.struts.actions;

public class LoginAction extends
		org.codelabor.system.login.web.struts.actions.LoginAction {

	@Override
	protected boolean isAuthenticated(String userId, String password) {
		return true;
	}
}
