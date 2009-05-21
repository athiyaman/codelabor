package org.codelabor.system.servlets.dtos;

import java.io.Serializable;

public class RemoteDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6420788348800357085L;
	String remoteHost;
	String remoteAddress;
	int remotePort;

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public int getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
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

		retValue.append("RemoteDTO ( ").append(super.toString()).append(TAB)
				.append("remoteAddress = ").append(this.remoteAddress).append(
						TAB).append("remoteHost = ").append(this.remoteHost)
				.append(TAB).append("remotePort = ").append(this.remotePort)
				.append(TAB).append(" )");

		return retValue.toString();
	}
}
