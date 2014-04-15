package org.codelabor.example.username.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

public class RegistrationFormDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8766825256742252770L;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@NotBlank
	@Length(min = 3, max = 255)
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String username;

	@Email
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String email;

	/**
	 *
	 */
	public RegistrationFormDto() {
	}

	/**
	 * @param username
	 * @param email
	 */
	public RegistrationFormDto(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RegistrationFormDto)) {
			return false;
		}
		RegistrationFormDto other = (RegistrationFormDto) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((email == null) ? 0 : email.hashCode());
		result = (prime * result)
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistrationFormDto [username=");
		builder.append(username);
		builder.append(", email=");
		builder.append(email);
		builder.append(']');
		return builder.toString();
	}
}
