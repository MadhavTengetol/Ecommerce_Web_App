package com.ecommerce.utils;

import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends RuntimeException {

	private HttpStatus status;

	public OrderNotFoundException(HttpStatus status, String message) {
		super(message);
		this.status = status;

	}

	public OrderNotFoundException(String message) {
		super(message);

	}

	
}
