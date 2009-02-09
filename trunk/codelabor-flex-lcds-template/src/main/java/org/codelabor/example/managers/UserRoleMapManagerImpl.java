package org.codelabor.example.managers;

import java.util.List;

import org.codelabor.example.daos.UserRoleMapDAO;
import org.codelabor.system.managers.BaseManagerImpl;

public class UserRoleMapManagerImpl extends BaseManagerImpl implements
		UserRoleMapManager {

	private UserRoleMapDAO userRoleMapDAO;

	public void setUserRoleMapDAO(UserRoleMapDAO userRoleMapDAO) {
		this.userRoleMapDAO = userRoleMapDAO;
	}

	public int map(String userId, String roleId) throws Exception {
		return userRoleMapDAO.map(userId, roleId);
	}

	public int reset() throws Exception {
		return userRoleMapDAO.reset();
	}

	public List<String> selectRoleIdList(String userId) throws Exception {
		return userRoleMapDAO.selectRoleIdList(userId);
	}

	public List<String> selectUserIdList(String roleId) throws Exception {
		return userRoleMapDAO.selectUserIdList(roleId);
	}

	public int unmap(String userId, String roleId) throws Exception {
		return userRoleMapDAO.unmap(userId, roleId);
	}

	public int reset(String userId) throws Exception {
		return userRoleMapDAO.reset(userId);
	}

}
