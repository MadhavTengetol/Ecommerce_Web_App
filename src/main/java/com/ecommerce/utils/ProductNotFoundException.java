package com.ecommerce.utils;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends EShopApiException {

	private HttpStatus status;
	private String message;

	public ProductNotFoundException(HttpStatus status, String message) {
		super(status, message);
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
