package org.codelabor.system.certification.pki.dtos;

import org.codelabor.system.certification.pki.CertificateType;

public class RegistrationDTO {
	private String referenceCode;
	private String authorizationCode;
	private String distinguishedName;
	private String serial;
	private String id;
	private String name;
	private String password;
	private CertificateType certificateType;
	public String getId() {
		return id;
	}
	public CertificateType getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(CertificateType certificateType) {
		this.certificateType = certificateType;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	private String registrationNumber;
	public String getReferenceCode() {
		return referenceCode;
	}
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
	public String getDistinguishedName() {
		return distinguishedName;
	}
	public void setDistinguishedName(String distinguishedName) {
		this.distinguishedName = distinguishedName;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("RegistrationDTO ( ")
	        .append(super.toString()).append(TAB)
	        .append("authorizationCode = ").append(this.authorizationCode).append(TAB)
	        .append("certificateType = ").append(this.certificateType).append(TAB)
	        .append("distinguishedName = ").append(this.distinguishedName).append(TAB)
	        .append("id = ").append(this.id).append(TAB)
	        .append("name = ").append(this.name).append(TAB)
	        .append("password = ").append(this.password).append(TAB)
	        .append("referenceCode = ").append(this.referenceCode).append(TAB)
	        .append("registrationNumber = ").append(this.registrationNumber).append(TAB)
	        .append("serial = ").append(this.serial).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
	
	
}
