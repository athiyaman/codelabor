package org.codelabor.example.user.managers;

import java.util.List;

import org.codelabor.example.user.daos.UserDAO;
import org.codelabor.example.user.dtos.UserDTO;
import org.codelabor.system.managers.BaseManagerImpl;

/**
 * @author Shin Sangjae
 * 
 */
public class UserManagerImpl extends BaseManagerImpl implements UserManager {

	/**
	 * 사용자 DAO
	 */
	private UserDAO userDAO;

	/**
	 * 사용자 DAO를 가져온다.
	 * 
	 * @return 사용자 DAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * 사용자 DAO를 설정한다.
	 * 
	 * @param userDAO
	 *            사용자 DAO
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserManager#deleteUser(java.lang.
	 * String)
	 */
	public int deleteUser(String userId) throws Exception {
		return userDAO.deleteUser(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.managers.UserManager#deleteUser()
	 */
	public int deleteUser() throws Exception {
		return userDAO.deleteUser();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserManager#insertUser(org.codelabor
	 * .example.user.dtos.UserDTO)
	 */
	public int insertUser(UserDTO userDTO) throws Exception {
		return userDAO.insertUser(userDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.managers.UserManager#selectUser()
	 */
	public List<UserDTO> selectUser() throws Exception {
		return userDAO.selectUser();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserManager#selectUserByUserId(java
	 * .lang.String)
	 */
	public UserDTO selectUserByUserId(String userId) throws Exception {
		return userDAO.selectUserByUserId(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserManager#updateUser(org.codelabor
	 * .example.user.dtos.UserDTO)
	 */
	public int updateUser(UserDTO userDTO) throws Exception {
		return userDAO.updateUser(userDTO);
	}

}
