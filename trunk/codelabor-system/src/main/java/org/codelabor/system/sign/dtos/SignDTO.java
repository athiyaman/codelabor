package org.codelabor.system.sign.dtos;

import java.io.Serializable;
import java.util.Date;

public class SignDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5094690949386181420L;

	private int id;
	private String subject;
	private String certType;
	private String certPem;
	private String signedMessage;
	private Date signedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertPem() {
		return certPem;
	}

	public void setCertPem(String certPem) {
		this.certPem = certPem;
	}

	public String getSignedMessage() {
		return signedMessage;
	}

	public void setSignedMessage(String signedMessage) {
		this.signedMessage = signedMessage;
	}

	public Date getSignedDate() {
		return signedDate;
	}

	public void setSignedDate(Date signedDate) {
		this.signedDate = signedDate;
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

		retValue.append("SignDTO ( ").append(super.toString()).append(TAB).append("certPem = ").append(this.certPem).append(TAB).append("certType = ").append(this.certType).append(TAB).append("id = ").append(this.id).append(TAB).append("signedDate = ").append(this.signedDate).append(TAB).append(
				"signedMessage = ").append(this.signedMessage).append(TAB).append("subject = ").append(this.subject).append(TAB).append(" )");

		return retValue.toString();
	}

}
