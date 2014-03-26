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

package org.codelabor.system.login.service;

import java.util.List;

import org.codelabor.system.anyframe.exceptions.CommonException;
import org.codelabor.system.anyframe.exceptions.RollbackCommonException;
import org.codelabor.system.login.dto.LoginDto;
import org.codelabor.system.login.manager.LoginManager;
import org.codelabor.system.services.BaseServiceImpl;

/**
 * 로그인 서비스 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

	/**
	 * 로그인 매니저
	 */
	public LoginManager loginManager;

	/**
	 * 로그인 매니저를 가져온다.
	 * 
	 * @return 로그인 매니저
	 */
	public LoginManager getLoginManager() {
		return loginManager;
	}

	/**
	 * 로그인 매니저를 설정한다.
	 * 
	 * @param loginManager
	 *            로그인 매니저
	 */
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.service.LoginService#login(org.codelabor.
	 * system.login.dto.LoginDto)
	 */
	public void login(LoginDto loginDto) throws Exception {
		try {
			loginManager.login(loginDto);
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0000";
			String messageKey = "error.login";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.service.LoginService#logout(org.codelabor
	 * .system.login.dto.LoginDTO)
	 */
	public void logout(LoginDto loginDto) throws Exception {
		try {
			loginManager.logout(loginDto);
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0001";
			String messageKey = "error.logout";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.login.service.LoginService#selectLogin()
	 */
	public List<LoginDto> selectLogin() throws Exception {
		List<LoginDto> loginList;
		try {
			loginList = loginManager.selectLogin();
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0002";
			String messageKey = "error.select";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
		return loginList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.service.LoginService#selectLogin(org.codelabor
	 * .system.login.dto.LoginDTO)
	 */
	public LoginDto selectLogin(LoginDto loginDto) throws Exception {
		LoginDto returnLoginDTO;
		try {
			returnLoginDTO = loginManager.selectLogin(loginDto);
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0003";
			String messageKey = "error.select";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
		return returnLoginDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.login.services.LoginService#
	 * selectLoginByLastLogoutUserId(org.codelabor.system.login.dto.LoginDto)
	 */
	public LoginDto selectLoginByLastLogoutUserId(LoginDto loginDto)
			throws Exception {
		LoginDto returnLoginDTO;
		try {
			returnLoginDTO = loginManager
					.selectLoginByLastLogoutUserId(loginDto);
		} catch (Exception e) {
			String messageCode = "ERROR-LOGIN-0004";
			String messageKey = "error.select";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
		return returnLoginDTO;
	}

}
