package org.codelabor.system.login.web.struts.forms;

import org.apache.struts.validator.ValidatorForm;

/**
 * 로그인 폼
 * 
 * @author Shin Sangjae
 * 
 */
public class LoginForm extends ValidatorForm {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -965468202375144262L;
	/**
	 * 사용자 Id
	 */
	private String userId = null;
	/**
	 * 패스워드
	 */
	private String password = null;

	/**
	 * 생성자
	 */
	public LoginForm() {
	}

	/**
	 * 패스워드를 가져온다.
	 * 
	 * @return 패스워드
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 패스워드를 설정한다.
	 * 
	 * @param password
	 *            패스워드
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 사용자 Id를 가져온다.
	 * 
	 * @return 사용자 Id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 사용자 Id를 설정한다.
	 * 
	 * @param userId
	 *            사용자 Id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
