package com.qa.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No project found with that id")
public class ProjectNotFoundException extends RuntimeException {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 309100135032325618L;
	public ProjectNotFoundException() {
		super();
	
	}
	
	public ProjectNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public ProjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public ProjectNotFoundException(String message) {
		super(message);
	}
	public ProjectNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}