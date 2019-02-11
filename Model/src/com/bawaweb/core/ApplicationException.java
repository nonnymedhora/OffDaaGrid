package com.bawaweb.core;

/**
 * @author nmedhora
 *  A generic exception subclasses RuntimeException
 */
public class ApplicationException extends RuntimeException {
	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}
	public ApplicationException(Throwable cause) {
		super(cause);
	}
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

}
