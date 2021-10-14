package com.qa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No powertool found with that id")
public class PowerToolNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3319003056702170343L;

	public PowerToolNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PowerToolNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PowerToolNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PowerToolNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PowerToolNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
