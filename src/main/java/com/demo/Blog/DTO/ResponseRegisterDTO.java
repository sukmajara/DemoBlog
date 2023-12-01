package com.demo.Blog.DTO;

public class ResponseRegisterDTO {
	String message;
	
	public ResponseRegisterDTO() {
		super();
	}

	public ResponseRegisterDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
