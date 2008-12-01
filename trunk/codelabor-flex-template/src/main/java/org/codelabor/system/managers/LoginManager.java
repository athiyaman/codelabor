package org.codelabor.system.managers;

import java.util.List;

import org.codelabor.system.dtos.LoginDTO;

public interface LoginManager {
	public void login(LoginDTO loginDTO) throws Exception;

	public void logout(LoginDTO loginDTO) throws Exception;

	public List<LoginDTO> selectLogin() throws Exception;

	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception;

	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception;
}
