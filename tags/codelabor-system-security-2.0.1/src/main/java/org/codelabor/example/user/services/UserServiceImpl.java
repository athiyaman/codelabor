/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.example.user.services;

import java.util.List;

import org.codelabor.example.user.dtos.UserDTO;
import org.codelabor.example.user.managers.UserManager;
import org.codelabor.example.user.managers.UserRoleMapManager;
import org.codelabor.system.services.BaseServiceImpl;

/**
 * 사용자 서비스 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	/**
	 * 사용자 역할 매핑 매니저
	 */
	protected UserRoleMapManager userRoleMapManager;
	/**
	 * 사용자 매니저
	 */
	protected UserManager userManager;

	/**
	 * 사용자 매니저를 설정한다.
	 * 
	 * @param userManager
	 *            사용자 매니저
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * 사용자 역할 매핑 매니저를 설정한다.
	 * 
	 * @param userRoleMapManager
	 *            사용자 역할 매핑 매니저
	 */
	public void setUserRoleMapManager(UserRoleMapManager userRoleMapManager) {
		this.userRoleMapManager = userRoleMapManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.services.UserService#deleteUser(java.lang.
	 * String)
	 */
	public int deleteUser(String userId) throws Exception {
		userRoleMapManager.reset(userId);
		return userManager.deleteUser(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.services.UserService#registerUser(org.codelabor
	 * .example.user.dtos.UserDTO, java.util.List)
	 */
	public int registerUser(UserDTO userDTO, List<String> roleIdList)
			throws Exception {
		userManager.insertUser(userDTO);
		for (String roleId : roleIdList) {
			userRoleMapManager.map(userDTO.getUserId(), roleId);
		}
		return roleIdList.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.services.UserService#updateUser(org.codelabor
	 * .example.user.dtos.UserDTO, java.util.List)
	 */
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
