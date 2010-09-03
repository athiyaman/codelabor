package org.codelabor.example.managers;

import java.util.List;

import org.codelabor.example.daos.UserDAO;
import org.codelabor.example.dtos.UserDTO;
import org.codelabor.system.managers.BaseManagerImpl;

public class UserManagerImpl extends BaseManagerImpl implements UserManager {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public int deleteUser(String userId) throws Exception {
		return userDAO.deleteUser(userId);
	}

	public int deleteUser() throws Exception {
		return userDAO.deleteUser();
	}

	public int insertUser(UserDTO userDTO) throws Exception {
		return userDAO.insertUser(userDTO);
	}

	public List<UserDTO> selectUser() throws Exception {
		return userDAO.selectUser();
	}

	public UserDTO selectUserByUserId(String userId) throws Exception {
		return userDAO.selectUserByUserId(userId);
	}

	public int updateUser(UserDTO userDTO) throws Exception {
		return userDAO.updateUser(userDTO);
	}

}
