package org.codelabor.example.validation.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@ScriptAssert.List({
	@ScriptAssert(lang = "javascript", script = "_this.password.equals(_this.passwordConfirm)", message = "{errors.confirm.password.mismatched}"),
	@ScriptAssert(lang = "javascript", script = "_this.email.equals(_this.emailConfirm)", message = "{errors.confirm.email.mismatched}") })
public class PersonDto {

	@NotBlank
	@Length(min = 3, max = 8)
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String username;

	@NotBlank
	@Pattern(regexp = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~`!@#$%^&*()_+\\-=\\[\\]\\{}|;':\",./<>?\\\\])(?=\\S+$).{5,10})", message = "{errors.password.mismatched}")
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String password;

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String passwordConfirm;

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String firstName;

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String lastName;

	@NotBlank
	@Pattern(regexp = "01\\d{1}-\\d{3,4}-\\d{4}")
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String mobilePhone;

	@Pattern(regexp = "0\\d{1,2}-\\d{3,4}-\\d{4}")
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String homePhone;

	@NotBlank
	@Email
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String email;

	@NotBlank
	@Email
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String emailConfirm;

	@NotBlank
	@Pattern(regexp = "\\d{3}-\\d{3}")
	@SafeHtml(whitelistType = WhiteListType.NONE)
	private String zipCode;

	@DateTimeFormat(iso = ISO.DATE)
	@Past
	private Date birthDate;

	public PersonDto() {
	}

	/**
	 * @param username
	 * @param password
	 * @param passwordConfirm
	 * @param firstName
	 * @param lastName
	 * @param mobilePhone
	 * @param homePhone
	 * @param email
	 * @param emailConfirm
	 * @param zipCode
	 * @param birthDate
	 */
	public PersonDto(String username, String password, String passwordConfirm,
			String firstName, String lastName, String mobilePhone,
			String homePhone, String email, String emailConfirm,
			String zipCode, Date birthDate) {
		super();
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobilePhone = mobilePhone;
		this.homePhone = homePhone;
		this.email = email;
		this.emailConfirm = emailConfirm;
		this.zipCode = zipCode;
		this.birthDate = birthDate;
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
		if (!(obj instanceof PersonDto)) {
			return false;
		}
		PersonDto other = (PersonDto) obj;
		if (birthDate == null) {
			if (other.birthDate != null) {
				return false;
			}
		} else if (!birthDate.equals(other.birthDate)) {
			return false;
		}
		if (emailConfirm == null) {
			if (other.emailConfirm != null) {
				return false;
			}
		} else if (!emailConfirm.equals(other.emailConfirm)) {
			return false;
		}
		if (passwordConfirm == null) {
			if (other.passwordConfirm != null) {
				return false;
			}
		} else if (!passwordConfirm.equals(other.passwordConfirm)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (homePhone == null) {
			if (other.homePhone != null) {
				return false;
			}
		} else if (!homePhone.equals(other.homePhone)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (mobilePhone == null) {
			if (other.mobilePhone != null) {
				return false;
			}
		} else if (!mobilePhone.equals(other.mobilePhone)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		if (zipCode == null) {
			if (other.zipCode != null) {
				return false;
			}
		} else if (!zipCode.equals(other.zipCode)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the emailConfirm
	 */
	public String getEmailConfirm() {
		return emailConfirm;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
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
		result = (prime * result)
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = (prime * result)
				+ ((emailConfirm == null) ? 0 : emailConfirm.hashCode());
		result = (prime * result)
				+ ((passwordConfirm == null) ? 0 : passwordConfirm.hashCode());
		result = (prime * result) + ((email == null) ? 0 : email.hashCode());
		result = (prime * result)
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = (prime * result)
				+ ((homePhone == null) ? 0 : homePhone.hashCode());
		result = (prime * result)
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = (prime * result)
				+ ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = (prime * result)
				+ ((password == null) ? 0 : password.hashCode());
		result = (prime * result)
				+ ((username == null) ? 0 : username.hashCode());
		result = (prime * result)
				+ ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param emailConfirm
	 *            the emailConfirm to set
	 */
	public void setEmailConfirm(String confirmEmail) {
		this.emailConfirm = confirmEmail;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param homePhone
	 *            the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param mobilePhone
	 *            the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param passwordConfirm
	 *            the passwordConfirm to set
	 */
	public void setPasswordConfirm(String confirmPassword) {
		this.passwordConfirm = confirmPassword;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonDto [username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", passwordConfirm=");
		builder.append(passwordConfirm);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", mobilePhone=");
		builder.append(mobilePhone);
		builder.append(", homePhone=");
		builder.append(homePhone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", emailConfirm=");
		builder.append(emailConfirm);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(']');
		return builder.toString();
	}

}
