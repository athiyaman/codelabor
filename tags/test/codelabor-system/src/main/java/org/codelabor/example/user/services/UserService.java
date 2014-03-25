package org.codelabor.example.user.services;

import java.util.List;

import org.codelabor.example.user.dtos.UserDTO;

public interface UserService {
	public int registerUser(UserDTO userDTO, List<String> roleIdList)
			throws Exception;

	public int updateUser(UserDTO userDTO, List<String> roleIdList)
			throws Exception;

	public int deleteUser(String userId) throws Exception;
}
