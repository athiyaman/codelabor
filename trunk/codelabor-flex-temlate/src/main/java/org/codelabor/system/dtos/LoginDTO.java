package org.codelabor.system.dtos;

import java.sql.Timestamp;

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
