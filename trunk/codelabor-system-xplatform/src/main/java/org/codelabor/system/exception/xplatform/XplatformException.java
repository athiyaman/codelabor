package org.codelabor.system.exception.xplatform;


/**
 * @author bomber.shin
 * 
 */
public class XplatformException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = -1909698597072186603L;

	private int errorCode = FAILURE_CODE;

	/**
	 *
	 */
	public XplatformException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public XplatformException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public XplatformException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public XplatformException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public XplatformException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public XplatformException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public XplatformException(int errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public XplatformException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
