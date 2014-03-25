package org.codelabor.example.user.daos;

import java.util.Collection;
import java.util.List;

import org.codelabor.example.user.dtos.UserDTO;
import org.codelabor.system.daos.BaseDAOImpl;

/**
 * 사용자 DAO 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.UserDAO#insertUser(org.codelabor.example
	 * .user.dtos.UserDTO)
	 */
	public int insertUser(UserDTO userDTO) throws Exception {
		return this.queryService.create(userDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.daos.UserDAO#selectUser()
	 */
	@SuppressWarnings("unchecked")
	public List<UserDTO> selectUser() throws Exception {
		String query = "example.select.user.list";
		Object[] param = new Object[] {};
		return (List<UserDTO>) this.queryService.find(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.UserDAO#selectUserByUserId(java.lang.
	 * String)
	 */
	@SuppressWarnings("unchecked")
	public UserDTO selectUserByUserId(String userId) throws Exception {
		String query = "example.select.user";
		Object[] param = new Object[] { userId };
		Collection userCol = this.queryService.find(query, param);
		if (userCol == null || userCol.size() == 0)
			return null;
		return (UserDTO) userCol.toArray()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.daos.UserDAO#deleteUser(java.lang.String)
	 */
	public int deleteUser(String userId) throws Exception {
		String query = "example.delete.user";
		Object[] param = new Object[] { userId };
		return this.queryService.remove(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.daos.UserDAO#deleteUser()
	 */
	public int deleteUser() throws Exception {
		String query = "example.delete.user.list";
		Object[] param = new Object[] {};
		return this.queryService.remove(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.UserDAO#updateUser(org.codelabor.example
	 * .user.dtos.UserDTO)
	 */
	public int updateUser(UserDTO userDTO) throws Exception {
		return this.queryService.update(userDTO);
	}

}
