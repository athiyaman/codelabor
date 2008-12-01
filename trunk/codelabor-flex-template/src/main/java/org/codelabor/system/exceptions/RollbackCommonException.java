package org.codelabor.system.exceptions;

import org.springframework.context.MessageSource;

public class RollbackCommonException extends CommonException implements
		Rollbackable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177604106387046530L;

	public RollbackCommonException() {
		super();

	}

	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters,
			String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, defaultMessage,
				wrappedException);

	}

	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters, String defaultMessage) {
		super(messageSource, messageKey, messageParameters, defaultMessage);

	}

	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters,
			Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, wrappedException);

	}

	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters) {
		super(messageSource, messageKey, messageParameters);

	}

	public RollbackCommonException(MessageSource messageSource,
			String messageKey, String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, defaultMessage, wrappedException);

	}

	public RollbackCommonException(MessageSource messageSource,
			String messageKey, String defaultMessage) {
		super(messageSource, messageKey, defaultMessage);

	}

	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Throwable wrappedException) {
		super(messageSource, messageKey, wrappedException);

	}

	public RollbackCommonException(MessageSource messageSource,
			String messageKey) {
		super(messageSource, messageKey);

	}

	public RollbackCommonException(String messageKey,
			Object[] messageParameters, Throwable wrappedException) {
		super(messageKey, messageParameters, wrappedException);

	}

	public RollbackCommonException(String messageKey, Object[] messageParameters) {
		super(messageKey, messageParameters);

	}

	public RollbackCommonException(String messageKey, Throwable wrappedException) {
		super(messageKey, wrappedException);

	}

	public RollbackCommonException(String messageKey) {
		super(messageKey);

	}

}
