package org.codelabor.example.banking.customer.dtos;

import java.io.Serializable;
import java.util.List;

import org.codelabor.financial.banking.InformType;
import org.codelabor.financial.banking.SecurityType;

public class CustomerDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -7742729885045574408L;
	private String customerId;
	private String name;
	private String smsCellPhoneNumber;
	private SecurityType securityType;
	private List<InformType> informTypes;
	private String otpTokenSerialNumber;
	private String securityCardSerialNumber;

	public String getOtpTokenSerialNumber() {
		return otpTokenSerialNumber;
	}

	public void setOtpTokenSerialNumber(String otpTokenSerialNumber) {
		this.otpTokenSerialNumber = otpTokenSerialNumber;
	}

	public String getSecurityCardSerialNumber() {
		return securityCardSerialNumber;
	}

	public void setSecurityCardSerialNumber(String securityCardSerialNumber) {
		this.securityCardSerialNumber = securityCardSerialNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSmsCellPhoneNumber() {
		return smsCellPhoneNumber;
	}

	public void setSmsCellPhoneNumber(String smsCellPhoneNumber) {
		this.smsCellPhoneNumber = smsCellPhoneNumber;
	}

	public SecurityType getSecurityType() {
		return securityType;
	}

	public void setSecurityType(SecurityType securityCard) {
		this.securityType = securityCard;
	}

	public List<InformType> getInformTypes() {
		return informTypes;
	}

	public void setInformTypes(List<InformType> informTypes) {
		this.informTypes = informTypes;
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

		retValue.append("CustomerDTO ( ").append(super.toString()).append(TAB).append("customerId = ").append(this.customerId).append(TAB).append("informTypes = ").append(this.informTypes).append(TAB).append("name = ").append(this.name).append(TAB).append("otpTokenSerialNumber = ").append(
				this.otpTokenSerialNumber).append(TAB).append("securityCardSerialNumber = ").append(this.securityCardSerialNumber).append(TAB).append("securityType = ").append(this.securityType).append(TAB).append("smsCellPhoneNumber = ").append(this.smsCellPhoneNumber).append(TAB).append(" )");

		return retValue.toString();
	}

}
