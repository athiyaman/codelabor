package org.codelabor.example.services;

import java.util.List;

import org.codelabor.example.dtos.UserDTO;
import org.codelabor.example.managers.UserManager;
import org.codelabor.example.managers.UserRoleMapManager;
import org.codelabor.system.services.BaseServiceImpl;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	protected UserRoleMapManager userRoleMapManager;
	protected UserManager userManager;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setUserRoleMapManager(UserRoleMapManager userRoleMapManager) {
		this.userRoleMapManager = userRoleMapManager;
	}

	public int deleteUser(String userId) throws Exception {
		userRoleMapManager.reset(userId);
		return userManager.deleteUser(userId);
	}

	public int registerUser(UserDTO userDTO, List<String> roleIdList)
			throws Exception {
		userManager.insertUser(userDTO);
		for (String roleId : roleIdList) {
			userRoleMapManager.map(userDTO.getUserId(), roleId);
		}
		return roleIdList.size();
	}

	public int updateUser(UserDTO userDTO, List<String> roleIdList)
			throws Exception {
		userManager.updateUser(userDTO);
		userRoleMapManager.reset(userDTO.getUserId());
		for (String roleId : roleIdList) {
			userRoleMapManager.map(userDTO.getUserId(), roleId);
		}
		return roleIdList.size();
	}
}
