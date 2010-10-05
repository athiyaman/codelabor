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

package org.codelabor.system.login.dtos;

import java.sql.Timestamp;

/**
 * 로그인 정보 DTO
 * 
 * @author Shin Sangjae
 * 
 */
public class LoginDTO {

	/**
	 * 세션 Id
	 */
	protected String sessionId = null;

	/**
	 * 사용자 Id
	 */
	protected String userId = null;

	/**
	 * 접속 주소
	 */
	protected String ipAddress = null;

	/**
	 * 로그인 시간
	 */
	protected Timestamp loginTimestamp = null;

	/**
	 * 로그아웃 시간
	 */
	protected Timestamp logoutTimestamp = null;

	/**
	 * 로그인 시간을 가져온다.
	 * 
	 * @return 로그인 시간
	 */
	public Timestamp getLoginTimestamp() {
		return loginTimestamp;
	}

	/**
	 * 로그인 시간을 설정한다.
	 * 
	 * @param loginTimestamp
	 *            로그인 시간
	 */
	public void setLoginTimestamp(Timestamp loginTimestamp) {
		this.loginTimestamp = loginTimestamp;
	}

	/**
	 * 로그아웃 시간을 가져온다.
	 * 
	 * @return 로그아웃 시간
	 */
	public Timestamp getLogoutTimestamp() {
		return logoutTimestamp;
	}

	/**
	 * 로그아웃 시간을 설정한다.
	 * 
	 * @param logoutTimestamp
	 *            로그아웃 시간
	 */
	public void setLogoutTimestamp(Timestamp logoutTimestamp) {
		this.logoutTimestamp = logoutTimestamp;
	}

	/**
	 * 사용자 Id를 가져온다.
	 * 
	 * @return 사용자 Id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 사용자 Id를 설정한다.
	 * 
	 * @param userId
	 *            사용자 Id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 접속 주소를 설정한다.
	 * 
	 * @param remoteAddr
	 *            접속 주소
	 */
	public void setIpAddress(String remoteAddr) {
		this.ipAddress = remoteAddr;
	}

	/**
	 * 접속 주소를 가져온다.
	 * 
	 * @return 접속 주소
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * 세션 Id를 가져온다.
	 * 
	 * @return 세션 Id
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * 세션 Id를 설정한다.
	 * 
	 * @param sessionId
	 *            세션 Id
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("LoginDTO ( ").append(super.toString()).append(TAB)
				.append("sessionId = ").append(this.sessionId).append(TAB)
				.append("userId = ").append(this.userId).append(TAB).append(
						"ipAddress = ").append(this.ipAddress).append(TAB)
				.append("loginTimestamp = ").append(this.loginTimestamp)
				.append(TAB).append("logoutTimestamp = ").append(
						this.logoutTimestamp).append(TAB).append(" )");

		return retValue.toString();
	}
}
