package org.codelabor.example.services;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.codelabor.example.dtos.UserDTO;
import org.codelabor.system.test.BaseTestCase;
import org.junit.Test;

public class UserServiceTest extends BaseTestCase {

	private UserService userService;

	@Override
	public void onSetUp() throws Exception {
		userService = (UserService) applicationContext
				.getBean("example.userService");
	}

	@Test
	public void testRegisterUser() {
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId("bomber");
			userDTO.setUserName("Shin Sang Jea");
			userDTO.setUserPassword("4321");

			List<String> roleIdList = new ArrayList<String>();
			roleIdList.add("ROLE_USER");
			roleIdList.add("ROLE_GUEST");
			int affectedRowCount = userService.registerUser(userDTO, roleIdList);
			Assert.assertEquals(2, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testUpdateUser() {
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId("bomber");
			userDTO.setUserName("Shin Sang Jea");
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] plainPassword = (new String("4321")).getBytes();
			byte[] hashedPassword = messageDigest.digest(plainPassword);
			userDTO.setUserPassword(new String(hashedPassword));

			List<String> roleIdList = new ArrayList<String>();
			roleIdList.add("ROLE_ADMIN");
			int affectedRowCount = userService.updateUser(userDTO, roleIdList);
			Assert.assertEquals(1, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testDeleteUser() {
		try {
			int affectedRowCount = userService.deleteUser("bomber");
			Assert.assertEquals(1, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
