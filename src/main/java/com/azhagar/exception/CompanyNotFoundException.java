package com.azhagar.exception;

public class CompanyNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4908109887968019752L;

	public CompanyNotFoundException() {
	}

	public CompanyNotFoundException(String message) {
		super(message);
	}

}
