package org.codelabor.system.exception;

public class UserException extends RuntimeException {

	public UserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserException(String arg0) {
		super(arg0);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6541437381236728538L;

}
