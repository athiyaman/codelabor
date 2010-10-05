package org.codelabor.system.sign.dtos;

import java.io.Serializable;
import java.util.Date;

public class SignDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5094690949386181420L;

	private int id;
	private String serial;
	private String subject;
	private String certType;
	private String certPem;
	private String signedMessage;
	private Date signedDate;
	
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}	

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

}
