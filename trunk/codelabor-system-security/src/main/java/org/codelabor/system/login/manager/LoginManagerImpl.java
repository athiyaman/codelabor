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

package org.codelabor.system.login.manager;

import java.util.List;

import org.codelabor.system.login.dao.LoginDao;
import org.codelabor.system.login.dto.LoginDto;
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
	public LoginDao loginDao;

	/**
	 * 로그인 DAO를 가져온다.
	 * 
	 * @return 로그인 DAO
	 */
	public LoginDao getLoginDAO() {
		return loginDao;
	}

	/**
	 * 로그인 DAO를 설정한다.
	 * 
	 * @param loginDao
	 *            로그인 DAO
	 */
	public void setLoginDAO(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.manager.LoginManager#login(org.codelabor.
	 * system.login.dto.LoginDto)
	 */
	public void login(LoginDto loginDto) throws Exception {
		loginDao.insertLogin(loginDto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.manager.LoginManager#logout(org.codelabor
	 * .system.login.dto.LoginDTO)
	 */
	public void logout(LoginDto loginDto) throws Exception {
		loginDao.updateLogin(loginDto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.login.manager.LoginManager#selectLogin()
	 */
	public List<LoginDto> selectLogin() throws Exception {
		return loginDao.selectLogin();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.manager.LoginManager#selectLogin(org.codelabor
	 * .system.login.dto.LoginDTO)
	 */
	public LoginDto selectLogin(LoginDto loginDto) throws Exception {
		return loginDao.selectLogin(loginDto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.login.managers.LoginManager#
	 * selectLoginByLastLogoutUserId(org.codelabor.system.login.dto.LoginDto)
	 */
	public LoginDto selectLoginByLastLogoutUserId(LoginDto loginDto)
			throws Exception {
		return loginDao.selectLoginByLastLogoutUserId(loginDto);
	}
}
