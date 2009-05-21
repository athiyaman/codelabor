package org.codelabor.system.servlets.dtos;

import java.io.Serializable;

public class LocalDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6420788348800357085L;
	String localName;
	String localAddress;
	int localPort;

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public int getLocalPort() {
		return localPort;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
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

		retValue.append("LocalDTO ( ").append(super.toString()).append(TAB)
				.append("localAddress = ").append(this.localAddress)
				.append(TAB).append("localName = ").append(this.localName)
				.append(TAB).append("localPort = ").append(this.localPort)
				.append(TAB).append(" )");

		return retValue.toString();
	}
}
