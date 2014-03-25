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

package org.codelabor.example.user.dtos;

/**
 * 사용자 DTO
 * 
 * @author Shin Sangjae
 * 
 */
public class UserDTO {

	/**
	 * 사용자 Id
	 */
	protected String userId = null;
	/**
	 * 사용자명
	 */
	protected String userName = null;
	/**
	 * 패스워드
	 */
	protected String userPassword = null;

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
	 * 패스워드를 가져온다.
	 * 
	 * @return 패스워드
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * 패스워드를 설정한다.
	 * 
	 * @param userPassword
	 *            패스워드
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 사용자명을 가져온다.
	 * 
	 * @return 사용자명
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 사용자명을 설정한다.
	 * 
	 * @param userName
	 *            사용자명
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

		retValue.append("UserDTO ( ").append(super.toString()).append(TAB)
				.append("userId = ").append(this.userId).append(TAB).append(
						"userName = ").append(this.userName).append(TAB)
				.append("userPassword = ").append(this.userPassword)
				.append(TAB).append(" )");

		return retValue.toString();
	}

}
