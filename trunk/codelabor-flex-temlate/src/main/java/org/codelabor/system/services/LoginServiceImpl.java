package org.codelabor.system.services;

import java.util.List;

import org.codelabor.system.dtos.LoginDTO;
import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.managers.LoginManager;

public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

	public LoginManager loginManager;

	public LoginManager getLoginManager() {
		return loginManager;
	}

	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

	public void login(LoginDTO loginDTO) throws Exception {
		try {
			loginManager.login(loginDTO);
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0000";
			String messageKey = "error.login";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
	}

	public void logout(LoginDTO loginDTO) throws Exception {
		try {
			loginManager.logout(loginDTO);
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0001";
			String messageKey = "error.logout";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
	}

	public List<LoginDTO> selectLogin() throws Exception {
		List<LoginDTO> loginList;
		try {
			loginList = loginManager.selectLogin();
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0002";
			String messageKey = "error.select";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
		return loginList;
	}

	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception {
		LoginDTO returnLoginDTO;
		try {
			returnLoginDTO = loginManager.selectLogin(loginDTO);
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0003";
			String messageKey = "error.select";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
		return returnLoginDTO;
	}

	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception {
		LoginDTO returnLoginDTO;
		try {
			returnLoginDTO = loginManager
					.selectLoginByLastLogoutUserId(loginDTO);
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0004";
			String messageKey = "error.select";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
		return returnLoginDTO;
	}

}
