package org.codelabor.system.servlets.dtos;

import java.io.Serializable;

public class ServerDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7382446064301468345L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	private int port;

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

		retValue.append("ServerDTO ( ").append(super.toString()).append(TAB)
				.append("name = ").append(this.name).append(TAB).append(
						"port = ").append(this.port).append(TAB).append(" )");

		return retValue.toString();
	}

}
