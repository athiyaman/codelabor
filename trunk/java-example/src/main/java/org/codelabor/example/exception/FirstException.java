package org.codelabor.example.exception;


public class FirstException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8850458172741513642L;

	public FirstException() {
		super();
	}

	public FirstException(String message, Throwable cause) {
		super(message, cause);
	}

	public FirstException(String message) {
		super(message);
	}

	public FirstException(Throwable cause) {
		super(cause);
	}

}
