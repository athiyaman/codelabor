package org.codelabor.example.struts.actions;

public abstract class LoginAction extends
		org.codelabor.system.struts.actions.LoginAction {

	@Override
	protected boolean isAuthenticated(String userId, String password) {
		return true;
	}
}
