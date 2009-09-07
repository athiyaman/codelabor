package org.codelabor.example.banking.bank.dtos;

import java.io.Serializable;

public class BankDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 4675722151459382799L;
	private String code;
	private String name;
	private boolean available;

	public String getCode() {
		return code;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

		retValue.append("BankDTO ( ").append(super.toString()).append(TAB).append("available = ").append(this.available).append(TAB).append("code = ").append(this.code).append(TAB).append("name = ").append(this.name).append(TAB).append(" )");

		return retValue.toString();
	}
}
