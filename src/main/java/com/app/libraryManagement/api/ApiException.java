package com.app.libraryManagement.api;
// TODO: Auto-generated Javadoc

/**
 * The Class ApiException.
 */
//comment
public class ApiException extends Exception{
	
	/** The code. */
	private int code;
	
	/**
	 * Instantiates a new api exception.
	 *
	 * @param code the code
	 * @param msg the msg
	 */
	public ApiException (int code, String msg) {
		super(msg);
		this.code = code;
	}
}
