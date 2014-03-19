package org.codelabor.system.net;

public class MalformedURLException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -6962551587080954842L;

	/**
	 *
	 */
	public MalformedURLException() {
		super();
	}

	/**
	 * @param message
	 */
	public MalformedURLException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MalformedURLException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public MalformedURLException(Throwable cause) {
		super(cause);
	}

}
