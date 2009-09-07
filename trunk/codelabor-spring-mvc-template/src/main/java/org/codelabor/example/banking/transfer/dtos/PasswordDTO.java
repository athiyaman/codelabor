package org.codelabor.example.banking.transfer.dtos;

import java.io.Serializable;

public class PasswordDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 8560663342106640667L;
	private String transferPassword;
	private String otpTokenSerialNumber;
	private String otpPassword;
	private String securityCardSerialNumber;

	public String getTransferPassword() {
		return transferPassword;
	}

	public void setTransferPassword(String transferPassword) {
		this.transferPassword = transferPassword;
	}

	public String getOtpTokenSerialNumber() {
		return otpTokenSerialNumber;
	}

	public void setOtpTokenSerialNumber(String otpTokenSerialNumber) {
		this.otpTokenSerialNumber = otpTokenSerialNumber;
	}

	public String getOtpPassword() {
		return otpPassword;
	}

	public void setOtpPassword(String otpPassword) {
		this.otpPassword = otpPassword;
	}

	public String getSecurityCardSerialNumber() {
		return securityCardSerialNumber;
	}

	public void setSecurityCardSerialNumber(String securityCardSerialNumber) {
		this.securityCardSerialNumber = securityCardSerialNumber;
	}

	public String getSecurityCardNumber1() {
		return securityCardNumber1;
	}

	public void setSecurityCardNumber1(String securityCardNumber1) {
		this.securityCardNumber1 = securityCardNumber1;
	}

	public String getSecurityCardNumber2() {
		return securityCardNumber2;
	}

	public void setSecurityCardNumber2(String securityCardNumber2) {
		this.securityCardNumber2 = securityCardNumber2;
	}

	private String securityCardNumber1;
	private String securityCardNumber2;

}
