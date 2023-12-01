package com.demo.Blog.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="blog-master")
public class Blog implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1272864557724961430L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="Title", nullable = false)
	private String title;
	
	@Column(name="Body", nullable = false)
	private String body;

	@Column(name="Author", nullable = false)
	private String author;
	
	@Column(name="created_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime created_at;
	
	@Column(name="updated_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime updated_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
