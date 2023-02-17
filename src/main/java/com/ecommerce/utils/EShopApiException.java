package com.ecommerce.utils;

import org.springframework.http.HttpStatus;

public class EShopApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;

	public EShopApiException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public EShopApiException(String message, HttpStatus status, String message1) {
		super(message);
		this.status = status;
		this.message = message1;
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
