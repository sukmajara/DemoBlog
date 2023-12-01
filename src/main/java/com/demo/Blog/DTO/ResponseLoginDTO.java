package com.demo.Blog.DTO;


public class ResponseLoginDTO {
	private String username;
	private String jwt;
	
	public ResponseLoginDTO() {
		super();
	}
	public ResponseLoginDTO(String username, String jwt) {
		super();
		this.username = username;
		this.jwt = jwt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
	
	
}
