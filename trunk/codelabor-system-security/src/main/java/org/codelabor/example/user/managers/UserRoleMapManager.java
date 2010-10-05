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

/**
 * 사용자 역할 정보 매핑 매니저 인터페이스
 * 
 * @author Shin Sangjae
 * 
 */
public interface UserRoleMapManager {

	/**
	 * 사용자 정보와 역할 정보를 매핑한다.
	 * 
	 * @param userId
	 *            사용자 Id
	 * @param roleId
	 *            역할 Id
	 * @return 매핑 건수
	 * @throws Exception
	 *             예외
	 */
	public int map(String userId, String roleId) throws Exception;

	/**
	 * 사용자 정보와 역할 정보의 매핑을 해제한다.
	 * 
	 * @param userId
	 *            사용자 Id
	 * @param roleId
	 *            역할 Id
	 * @return 해제 매핑 건수
	 * @throws Exception
	 *             예외
	 */
	public int unmap(String userId, String roleId) throws Exception;

	/**
	 * 매핑 정보를 초기화한다.
	 * 
	 * @return 초기화 건수
	 * @throws Exception
	 *             예외
	 */
	public int reset() throws Exception;

	/**
	 * 매핑 정보를 초기화한다.
	 * 
	 * @param userId
	 *            사용자 Id
	 * @return 초기화 건수
	 * @throws Exception
	 *             예외
	 */
	public int reset(String userId) throws Exception;

	/**
	 * 역할 Id List를 가져온다.
	 * 
	 * @param userId
	 *            사용자 Id
	 * @return 역할 Id List
	 * @throws Exception
	 *             예외
	 */
	public List<String> selectRoleIdList(String userId) throws Exception;

	/**
	 * 사용자 Id List를 가져온다.
	 * 
	 * @param roleId
	 *            역할 Id
	 * @return 사용자 Id List
	 * @throws Exception
	 *             예외
	 */
	public List<String> selectUserIdList(String roleId) throws Exception;

}
