package org.codelabor.system.daos;

import java.util.List;

import org.codelabor.system.dtos.LoginDTO;

public interface LoginDAO {
	public int insertLogin(LoginDTO loginDTO) throws Exception;

	public int updateLogin(LoginDTO loginDTO) throws Exception;

	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception;

	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception;

	public List<LoginDTO> selectLogin() throws Exception;
}
