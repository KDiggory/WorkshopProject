package com.qa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No workshop found with that id")
public class WorkshopNotFoundException extends RuntimeException {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2185960866249302773L;
	public WorkshopNotFoundException() {
		super();
	
	}
	
	public WorkshopNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public WorkshopNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public WorkshopNotFoundException(String message) {
		super(message);
	}
	public WorkshopNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
