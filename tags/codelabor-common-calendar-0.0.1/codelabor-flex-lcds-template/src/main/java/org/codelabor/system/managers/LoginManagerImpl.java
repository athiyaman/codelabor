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

package org.codelabor.system.managers;

import java.util.List;

import org.codelabor.system.daos.LoginDAO;
import org.codelabor.system.dtos.LoginDTO;

/**
 * @author SangJae Shin
 * 
 */
public class LoginManagerImpl extends BaseManagerImpl implements LoginManager {

	public LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public void login(LoginDTO loginDTO) throws Exception {
		loginDAO.insertLogin(loginDTO);
	}

	public void logout(LoginDTO loginDTO) throws Exception {
		loginDAO.updateLogin(loginDTO);
	}

	public List<LoginDTO> selectLogin() throws Exception {
		return loginDAO.selectLogin();
	}

	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception {
		return loginDAO.selectLogin(loginDTO);
	}

	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception {
		return loginDAO.selectLoginByLastLogoutUserId(loginDTO);
	}
}
