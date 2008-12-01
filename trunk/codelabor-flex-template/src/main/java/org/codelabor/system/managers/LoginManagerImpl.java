package org.codelabor.system.managers;

import java.util.List;

import org.codelabor.system.daos.LoginDAO;
import org.codelabor.system.dtos.LoginDTO;

public class LoginManagerImpl extends BaseManagerImpl implements LoginManager {

	public LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public void login(LoginDTO loginDTO) throws Exception {
		loginDAO.insertLogin(loginDTO);
	}

	public void logout(LoginDTO loginDTO) throws Exception {
		loginDAO.updateLogin(loginDTO);
	}

	public List<LoginDTO> selectLogin() throws Exception {
		return loginDAO.selectLogin();
	}

	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception {
		return loginDAO.selectLogin(loginDTO);
	}

	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception {
		return loginDAO.selectLoginByLastLogoutUserId(loginDTO);
	}
}
