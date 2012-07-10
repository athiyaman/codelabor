package org.codelabor.example.oxm.xstream.dto;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5374139559927203160L;
	private int code;
	private String number;

	/**
	 * @param code
	 * @param number
	 */
	public PhoneNumber(int code, String number) {
		super();
		this.code = code;
		this.number = number;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PhoneNumber [code=");
		builder.append(code);
		builder.append(", number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}

}
