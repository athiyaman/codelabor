package org.codelabor.system.exceptions;

import org.springframework.context.MessageSource;

import anyframe.common.exception.BaseException;
import anyframe.common.exception.message.Message;

public abstract class CommonException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2522334283452895450L;
	private String messageCode;

	public CommonException() {
		super();
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public CommonException(MessageSource messageSource, String messageKey,
			Object[] messageParameters, String defaultMessage,
			Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, defaultMessage,
				wrappedException);
	}

	public CommonException(MessageSource messageSource, String messageKey,
			Object[] messageParameters, String defaultMessage) {
		super(messageSource, messageKey, messageParameters, defaultMessage);
	}

	public CommonException(MessageSource messageSource, String messageKey,
			Object[] messageParameters, Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, wrappedException);
	}

	public CommonException(MessageSource messageSource, String messageKey,
			Object[] messageParameters) {
		super(messageSource, messageKey, messageParameters);
	}

	public CommonException(MessageSource messageSource, String messageKey,
			String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, defaultMessage, wrappedException);
	}

	public CommonException(MessageSource messageSource, String messageKey,
			String defaultMessage) {
		super(messageSource, messageKey, defaultMessage);
	}

	public CommonException(MessageSource messageSource, String messageKey,
			Throwable wrappedException) {
		super(messageSource, messageKey, wrappedException);
	}

	public CommonException(MessageSource messageSource, String messageKey) {
		super(messageSource, messageKey);
	}

	public CommonException(String messageKey, Object[] messageParameters,
			Throwable wrappedException) {
		super(messageKey, messageParameters, wrappedException);
	}

	public CommonException(String messageKey, Object[] messageParameters) {
		super(messageKey, messageParameters);
	}

	public CommonException(String messageKey, Throwable wrappedException) {
		super(messageKey, wrappedException);
	}

	public CommonException(String messageKey) {
		super(messageKey);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public String getMessageKey() {
		return super.getMessageKey();
	}

	@Override
	public Object[] getMessageParameters() {
		return super.getMessageParameters();
	}

	@Override
	public Message getMessages() {
		return super.getMessages();
	}

	@Override
	public void setMessageKey(String messageKey) {
		super.setMessageKey(messageKey);
	}

	@Override
	public void setMessageParameters(Object[] param) {
		super.setMessageParameters(param);
	}

	public String getMessageCode() {
		return this.messageCode;
	}

}
