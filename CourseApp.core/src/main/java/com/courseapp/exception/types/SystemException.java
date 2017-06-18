package com.courseapp.exception.types;

@SuppressWarnings("serial")
public class SystemException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "SystemException [message=" + message + "]";
	}
	
	
}
