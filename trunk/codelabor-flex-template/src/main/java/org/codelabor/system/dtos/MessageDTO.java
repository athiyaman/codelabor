package org.codelabor.system.dtos;

import java.io.Serializable;

import org.codelabor.system.MessageType;

public class MessageDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7653402956922788460L;

	private MessageType messageType;

	private String messageKey;

	private String messageCode;

	private String userMessage;

	private String solution;

	private String reason;

	public MessageDTO() {
		super();
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

		retValue.append("MessageDTO ( ").append(super.toString()).append(TAB)
				.append("messageType = ").append(this.messageType).append(TAB)
				.append("messageKey = ").append(this.messageKey).append(TAB)
				.append("messageCode = ").append(this.messageCode).append(TAB)
				.append("userMessage = ").append(this.userMessage).append(TAB)
				.append("solution = ").append(this.solution).append(TAB)
				.append("reason = ").append(this.reason).append(TAB).append(
						" )");

		return retValue.toString();
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
}
