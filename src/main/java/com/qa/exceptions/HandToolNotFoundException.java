package com.qa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No hand tool found with that id")
public class HandToolNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3572306452491968784L;

	public HandToolNotFoundException() {
		super(); 
		// TODO Auto-generated constructor stub
	}

	public HandToolNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HandToolNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HandToolNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HandToolNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
