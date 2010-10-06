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

package org.codelabor.system.login.managers;

import java.util.List;

import org.codelabor.system.login.daos.LoginDAO;
import org.codelabor.system.login.dtos.LoginDTO;
import org.codelabor.system.managers.BaseManagerImpl;

/**
 * 로그인 매니저 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class LoginManagerImpl extends BaseManagerImpl implements LoginManager {

	/**
	 * 로그인 DAO
	 */
	public LoginDAO loginDAO;

	/**
	 * 로그인 DAO를 가져온다.
	 * 
	 * @return 로그인 DAO
	 */
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	/**
	 * 로그인 DAO를 설정한다.
	 * 
	 * @param loginDAO
	 *            로그인 DAO
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.managers.LoginManager#login(org.codelabor.
	 * system.login.dtos.LoginDTO)
	 */
	public void login(LoginDTO loginDTO) throws Exception {
		loginDAO.insertLogin(loginDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.managers.LoginManager#logout(org.codelabor
	 * .system.login.dtos.LoginDTO)
	 */
	public void logout(LoginDTO loginDTO) throws Exception {
		loginDAO.updateLogin(loginDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.login.managers.LoginManager#selectLogin()
	 */
	public List<LoginDTO> selectLogin() throws Exception {
		return loginDAO.selectLogin();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.managers.LoginManager#selectLogin(org.codelabor
	 * .system.login.dtos.LoginDTO)
	 */
	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception {
		return loginDAO.selectLogin(loginDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.login.managers.LoginManager#
	 * selectLoginByLastLogoutUserId(org.codelabor.system.login.dtos.LoginDTO)
	 */
	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception {
		return loginDAO.selectLoginByLastLogoutUserId(loginDTO);
	}
}
