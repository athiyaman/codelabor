package org.codelabor.system.exceptions;

import org.springframework.context.MessageSource;

public class NoRollbackCommonException extends CommonException implements
		NoRollbackable {

	public NoRollbackCommonException() {
		super();

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters,
			String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, defaultMessage,
				wrappedException);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters, String defaultMessage) {
		super(messageSource, messageKey, messageParameters, defaultMessage);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters,
			Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, wrappedException);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters) {
		super(messageSource, messageKey, messageParameters);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, defaultMessage, wrappedException);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, String defaultMessage) {
		super(messageSource, messageKey, defaultMessage);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Throwable wrappedException) {
		super(messageSource, messageKey, wrappedException);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey) {
		super(messageSource, messageKey);

	}

	public NoRollbackCommonException(String messageKey,
			Object[] messageParameters, Throwable wrappedException) {
		super(messageKey, messageParameters, wrappedException);

	}

	public NoRollbackCommonException(String messageKey,
			Object[] messageParameters) {
		super(messageKey, messageParameters);

	}

	public NoRollbackCommonException(String messageKey,
			Throwable wrappedException) {
		super(messageKey, wrappedException);

	}

	public NoRollbackCommonException(String messageKey) {
		super(messageKey);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3414460040784097981L;

}
