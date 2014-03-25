package org.codelabor.example.user.services;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.codelabor.example.user.dtos.UserDTO;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class UserServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private UserService userService;

	@Override
	public void onSetUp() throws Exception {
		userService = (UserService) applicationContext
				.getBean("example.userService");
	}

	public void testRegisterUser() {
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId("bomber");
			userDTO.setUserName("Shin Sang Jea");
			userDTO.setUserPassword("4321");

			List<String> roleIdList = new ArrayList<String>();
			roleIdList.add("USER");
			roleIdList.add("GUEST");
			int affectedRowCount = userService
					.registerUser(userDTO, roleIdList);
			Assert.assertEquals(2, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

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
			roleIdList.add("ADMIN");
			int affectedRowCount = userService.updateUser(userDTO, roleIdList);
			Assert.assertEquals(1, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testDeleteUser() {
		try {
			int affectedRowCount = userService.deleteUser("bomber");
			Assert.assertEquals(1, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
