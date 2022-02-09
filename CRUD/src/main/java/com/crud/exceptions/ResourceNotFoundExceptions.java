package com.crud.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundExceptions extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundExceptions(String message) {
		super(message);
	}
	public ResourceNotFoundExceptions(String message, Throwable throwable) {
		super(message, throwable);
	}
}
