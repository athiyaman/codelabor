package org.codelabor.example.oxm.xstream.dto;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3980933569033071557L;
	private String firstname;
	private String lastname;
	private PhoneNumber phone;
	private PhoneNumber fax;

	/**
	 * @param firstname
	 * @param lastname
	 */
	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the phone
	 */
	public PhoneNumber getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	/**
	 * @return the fax
	 */
	public PhoneNumber getFax() {
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(PhoneNumber fax) {
		this.fax = fax;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [firstname=");
		builder.append(firstname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", fax=");
		builder.append(fax);
		builder.append("]");
		return builder.toString();
	}

}
