package org.codelabor.system.sign.exceptions;

import org.codelabor.system.anyframe.exceptions.RollbackCommonException;
import org.springframework.context.MessageSource;

public class NotVerifiedException extends RollbackCommonException {

	/**
	 *
	 */
	private static final long serialVersionUID = 9060172443413310800L;

	public NotVerifiedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(MessageSource messageSource, String messageKey, Object[] messageParameters, String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, defaultMessage, wrappedException);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(MessageSource messageSource, String messageKey, Object[] messageParameters, String defaultMessage) {
		super(messageSource, messageKey, messageParameters, defaultMessage);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(MessageSource messageSource, String messageKey, Object[] messageParameters, Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, wrappedException);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(MessageSource messageSource, String messageKey, Object[] messageParameters) {
		super(messageSource, messageKey, messageParameters);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(MessageSource messageSource, String messageKey, String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, defaultMessage, wrappedException);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(MessageSource messageSource, String messageKey, String defaultMessage) {
		super(messageSource, messageKey, defaultMessage);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(MessageSource messageSource, String messageKey, Throwable wrappedException) {
		super(messageSource, messageKey, wrappedException);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(MessageSource messageSource, String messageKey) {
		super(messageSource, messageKey);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(String messageKey, Object[] messageParameters, Throwable wrappedException) {
		super(messageKey, messageParameters, wrappedException);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(String messageKey, Object[] messageParameters) {
		super(messageKey, messageParameters);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(String messageKey, Throwable wrappedException) {
		super(messageKey, wrappedException);
		// TODO Auto-generated constructor stub
	}

	public NotVerifiedException(String messageKey) {
		super(messageKey);
		// TODO Auto-generated constructor stub
	}

}
