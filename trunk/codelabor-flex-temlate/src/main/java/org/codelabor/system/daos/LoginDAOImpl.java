package org.codelabor.system.daos;

import java.util.Collection;
import java.util.List;

import org.codelabor.system.dtos.LoginDTO;

public class LoginDAOImpl extends BaseDAOImpl implements LoginDAO {

	public int insertLogin(LoginDTO loginDTO) throws Exception {
		String queryId = "system.insert.login";
		Object[] param = new Object[] { loginDTO.getSessionId(),
				loginDTO.getUserId(), loginDTO.getIpAddress() };
		return this.queryService.create(queryId, param);
	}

	@SuppressWarnings("unchecked")
	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception {
		String queryId = "system.select.login";
		Object[] param = new Object[] { loginDTO.getSessionId() };
		Collection<LoginDTO> loginCol = queryService.find(queryId, param);
		if (loginCol == null || loginCol.size() == 0)
			return null;
		return (LoginDTO) loginCol.toArray()[0];
	}

	@SuppressWarnings("unchecked")
	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception {
		String queryId = "system.select.login.by.last.logout.user.id";
		Object[] param = new Object[] { loginDTO.getUserId() };
		Collection<LoginDTO> loginCol = queryService.find(queryId, param);
		if (loginCol == null || loginCol.size() == 0)
			return null;
		return (LoginDTO) loginCol.toArray()[0];
	}

	@SuppressWarnings("unchecked")
	public List<LoginDTO> selectLogin() throws Exception {
		String queryId = "system.select.login.list";
		Object[] params = new Object[] {};
		return (List<LoginDTO>) queryService.find(queryId, params);
	}

	public int updateLogin(LoginDTO loginDTO) throws Exception {
		String queryId = "system.update.login";
		Object[] param = new Object[] { loginDTO.getSessionId() };
		return this.queryService.create(queryId, param);
	}

}
