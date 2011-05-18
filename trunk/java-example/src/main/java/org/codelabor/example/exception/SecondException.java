package org.codelabor.example.exception;

public class SecondException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8301678059547351204L;

	public SecondException() {
		super();
	}

	public SecondException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecondException(String message) {
		super(message);
	}

	public SecondException(Throwable cause) {
		super(cause);
	}

}
