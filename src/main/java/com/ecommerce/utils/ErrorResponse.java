package com.ecommerce.utils;

public class ErrorResponse {

	private int status;
	private String message;
	private String timestamp;

	public ErrorResponse() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String string) {
		this.timestamp = string;
	}

	

}
