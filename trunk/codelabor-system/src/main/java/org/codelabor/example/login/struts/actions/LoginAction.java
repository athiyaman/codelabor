package org.codelabor.example.login.struts.actions;

public class LoginAction extends
		org.codelabor.system.login.struts.actions.LoginAction {

	@Override
	protected boolean isAuthenticated(String userId, String password) {
		return true;
	}
}
