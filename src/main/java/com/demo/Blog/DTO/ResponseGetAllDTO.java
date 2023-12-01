package com.demo.Blog.DTO;

import java.util.List;

import com.demo.Blog.domain.Blog;

public class ResponseGetAllDTO {
	String resCode;
	String resMsg;
	String record;
	List<Blog> message;
	public ResponseGetAllDTO() {
		super();
	}
	public ResponseGetAllDTO(String resCode, String resMsg, String record, List<Blog> message) {
		super();
		this.resCode = resCode;
		this.resMsg = resMsg;
		this.record = record;
		this.message = message;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public List<Blog> getMessage() {
		return message;
	}
	public void setMessage(List<Blog> message) {
		this.message = message;
	}
	
	
	
	
}
