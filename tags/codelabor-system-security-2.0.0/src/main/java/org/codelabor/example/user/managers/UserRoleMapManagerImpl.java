package org.codelabor.example.user.managers;

import java.util.List;

import org.codelabor.example.user.daos.UserRoleMapDAO;
import org.codelabor.system.managers.BaseManagerImpl;

/**
 * 사용자 역할 정보 매핑 매니저 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class UserRoleMapManagerImpl extends BaseManagerImpl implements
		UserRoleMapManager {

	/**
	 * 사용자 역할 매핑 DAO
	 */
	private UserRoleMapDAO userRoleMapDAO;

	/**
	 * 사용자 역할 매핑 DAO를 설정한다.
	 * 
	 * @param userRoleMapDAO
	 *            사용자 역할 매핑 DAO
	 */
	public void setUserRoleMapDAO(UserRoleMapDAO userRoleMapDAO) {
		this.userRoleMapDAO = userRoleMapDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserRoleMapManager#map(java.lang.
	 * String, java.lang.String)
	 */
	public int map(String userId, String roleId) throws Exception {
		return userRoleMapDAO.map(userId, roleId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.managers.UserRoleMapManager#reset()
	 */
	public int reset() throws Exception {
		return userRoleMapDAO.reset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserRoleMapManager#selectRoleIdList
	 * (java.lang.String)
	 */
	public List<String> selectRoleIdList(String userId) throws Exception {
		return userRoleMapDAO.selectRoleIdList(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserRoleMapManager#selectUserIdList
	 * (java.lang.String)
	 */
	public List<String> selectUserIdList(String roleId) throws Exception {
		return userRoleMapDAO.selectUserIdList(roleId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserRoleMapManager#unmap(java.lang
	 * .String, java.lang.String)
	 */
	public int unmap(String userId, String roleId) throws Exception {
		return userRoleMapDAO.unmap(userId, roleId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.UserRoleMapManager#reset(java.lang
	 * .String)
	 */
	public int reset(String userId) throws Exception {
		return userRoleMapDAO.reset(userId);
	}

}
