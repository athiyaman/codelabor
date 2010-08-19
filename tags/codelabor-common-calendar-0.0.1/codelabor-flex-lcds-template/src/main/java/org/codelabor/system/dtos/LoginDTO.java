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

package org.codelabor.system.dtos;

import java.sql.Timestamp;

/**
 * @author SangJae Shin
 * 
 */
public class LoginDTO {

	protected String sessionId = null;

	protected String userId = null;

	protected String ipAddress = null;

	protected Timestamp loginTimestamp = null;

	protected Timestamp logoutTimestamp = null;

	public Timestamp getLoginTimestamp() {
		return loginTimestamp;
	}

	public void setLoginTimestamp(Timestamp loginTimestamp) {
		this.loginTimestamp = loginTimestamp;
	}

	public Timestamp getLogoutTimestamp() {
		return logoutTimestamp;
	}

	public void setLogoutTimestamp(Timestamp logoutTimestamp) {
		this.logoutTimestamp = logoutTimestamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setIpAddress(String remoteAddr) {
		this.ipAddress = remoteAddr;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getSessionId() {
		return sessionId;
	}

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
