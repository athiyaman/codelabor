package org.codelabor.example.services;

import java.util.List;

import org.codelabor.example.dtos.UserDTO;

public interface UserService {
	public int registerUser(UserDTO userDTO, List<String> roleIdList)
			throws Exception;

	public int updateUser(UserDTO userDTO, List<String> roleIdList)
			throws Exception;

	public int deleteUser(String userId) throws Exception;
}
