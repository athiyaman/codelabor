package org.codelabor.system.exception;

public class SystemException extends RuntimeException {

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6237762682211191700L;

}
