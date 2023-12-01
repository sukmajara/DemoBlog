package com.demo.Blog.DTO;

public class RegisterUserDTO {
	private String username;
	private String password;

	
	
	public RegisterUserDTO() {
		super();
	}

	public RegisterUserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "registration info : username :"+this.username+" password : "+this.password;
	}

}
