package com.ecommerce.utils;

public class OrderItemNotFoundException extends RuntimeException {

	public OrderItemNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public OrderItemNotFoundException(String message) {
		super(message);

	}

	public OrderItemNotFoundException(Throwable cause) {
		super(cause);

	}

}
