package org.codelabor.example.remoting.tcp.dtos;

import java.io.Serializable;

public class MessageDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -808326127333666877L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
