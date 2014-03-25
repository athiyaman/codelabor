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

package org.codelabor.example.user.managers;

import java.util.List;

import org.codelabor.example.user.dtos.RoleDTO;

/**
 * 역할 매니저 인터페이스
 * 
 * @author Shin Sangjae
 * 
 */
public interface RoleManager {
	/**
	 * 역할 DTO를 입력한다.
	 * 
	 * @param roleDTO
	 *            역할 DTO
	 * @return 입력 건수
	 * @throws Exception
	 *             예외
	 */
	public int insertRole(RoleDTO roleDTO) throws Exception;

	/**
	 * 역할 DTO를 수정한다.
	 * 
	 * @param roleDTO
	 *            역할 DTO
	 * @return 수정 건수
	 * @throws Exception
	 *             예외
	 */
	public int updateRole(RoleDTO roleDTO) throws Exception;

	/**
	 * 역할 정보를 삭제한다.
	 * 
	 * @param roleDTO
	 *            역할 Id
	 * @return 삭제 건수
	 * @throws Exception
	 *             예외
	 */
	public int deleteRole(String roleId) throws Exception;

	/**
	 * 역할 정보를 삭제한다.
	 * 
	 * @return 삭제 건수
	 * @throws Exception
	 *             예외
	 */
	public int deleteRole() throws Exception;

	/**
	 * 역할 정보를 가져온다.
	 * 
	 * @param roleId
	 *            역할 Id
	 * @return 역할 DTO
	 * @throws Exception
	 *             예외
	 */
	public RoleDTO selectRoleByRoleId(String roleId) throws Exception;

	/**
	 * 역할 정보를 가져온다.
	 * 
	 * @return 역할 DTO List
	 * @throws Exception
	 *             예외
	 */
	public List<RoleDTO> selectRole() throws Exception;

	/**
	 * 역할 정보를 가져온다.
	 * 
	 * @param userId
	 *            사용자 Id
	 * @return 역할 DTO List
	 * @throws Exception
	 *             예외
	 */
	public List<RoleDTO> selectRoleByUserId(String userId) throws Exception;
}
