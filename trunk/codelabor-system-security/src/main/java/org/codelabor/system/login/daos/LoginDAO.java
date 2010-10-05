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

package org.codelabor.system.login.daos;

import java.util.List;

import org.codelabor.system.login.dtos.LoginDTO;

/**
 * 로그인 DAO
 * 
 * @author Shin Sangjae
 * 
 */
public interface LoginDAO {
	/**
	 * 로그인 정보를 등록한다.
	 * 
	 * @param loginDTO
	 *            로그인 정보 DTO
	 * @return 등록 건수
	 * @throws Exception
	 *             예외
	 */
	public int insertLogin(LoginDTO loginDTO) throws Exception;

	/**
	 * 로그인 정보를 수정한다.
	 * 
	 * @param loginDTO
	 *            로그인 정보 DTO
	 * @return 수정 건수
	 * @throws Exception
	 *             예외
	 */
	public int updateLogin(LoginDTO loginDTO) throws Exception;

	/**
	 * 로그인 정보를 가져온다.
	 * 
	 * @param loginDTO
	 *            로그인 정보 DTO
	 * @return 로그인 정보 DTO
	 * @throws Exception
	 *             예외
	 */
	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception;

	/**
	 * 마지막에 로그아웃한 로그인 정보를 가져온다.
	 * 
	 * @param loginDTO
	 *            로그인 정보 DTO
	 * @return 로그인 정보 DTO
	 * @throws Exception
	 *             예외
	 */
	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception;

	/**
	 * 로그인 정보를 가져온다.
	 * 
	 * @return 로그인 정보 DTO List
	 * @throws Exception
	 */
	public List<LoginDTO> selectLogin() throws Exception;
}
