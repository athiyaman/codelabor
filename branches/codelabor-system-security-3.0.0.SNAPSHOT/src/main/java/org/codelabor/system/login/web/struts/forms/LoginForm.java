package org.codelabor.system.login.web.struts.forms;

import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -965468202375144262L;
	private String userId = null;
	private String password = null;

	public LoginForm() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
