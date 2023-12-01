package com.demo.Blog.DTO;

import jakarta.validation.constraints.NotBlank;

public class UpdateRequestDTO {
	private String Id;
	private String title;
	private String body;
	private String author;
	
	@NotBlank(message = "Title cannot be blank")
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	@NotBlank(message = "Title cannot be blank")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@NotBlank(message = "Body cannot be blank")
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@NotBlank(message = "Author cannot be blank")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
