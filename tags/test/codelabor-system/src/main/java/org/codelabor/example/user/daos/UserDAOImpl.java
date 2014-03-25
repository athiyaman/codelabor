package org.codelabor.example.user.daos;

import java.util.Collection;
import java.util.List;

import org.codelabor.example.user.dtos.UserDTO;
import org.codelabor.system.daos.BaseDAOImpl;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

	public int insertUser(UserDTO userDTO) throws Exception {
		return this.queryService.create(userDTO);
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> selectUser() throws Exception {
		String query = "example.select.user.list";
		Object[] param = new Object[] {};
		return (List<UserDTO>) this.queryService.find(query, param);
	}

	@SuppressWarnings("unchecked")
	public UserDTO selectUserByUserId(String userId) throws Exception {
		String query = "example.select.user";
		Object[] param = new Object[] { userId };
		Collection userCol = this.queryService.find(query, param);
		if (userCol == null || userCol.size() == 0)
			return null;
		return (UserDTO) userCol.toArray()[0];
	}

	public int deleteUser(String userId) throws Exception {
		String query = "example.delete.user";
		Object[] param = new Object[] {userId};
		return this.queryService.remove(query, param);
	}

	public int deleteUser() throws Exception {
		String query = "example.delete.user.list";
		Object[] param = new Object[] {};
		return this.queryService.remove(query, param);
	}

	public int updateUser(UserDTO userDTO) throws Exception {
		return this.queryService.update(userDTO);
	}

}
