package org.codelabor.system.certification.pki.dtos;

public class CodeDTO {
	private String referenceCode;
	private String authorizationCode;
	private String distinguishedName;
	private String serial;
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
	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	@Override
	public String toString()
	{
	    final String TAB = "    ";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("CodeDTO ( ")
	        .append(super.toString()).append(TAB)
	        .append("authorizationCode = ").append(this.authorizationCode).append(TAB)
	        .append("distinguishedName = ").append(this.distinguishedName).append(TAB)
	        .append("referenceCode = ").append(this.referenceCode).append(TAB)
	        .append("serial = ").append(this.serial).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	
}
