package com.demo.Blog.DTO;

public class ResponseUpdateDTO {
	private String resMsg;
	private String resCode;
	private DataBlog message;
	
	public ResponseUpdateDTO() {
		super();
	}
	public ResponseUpdateDTO(String resMsg, String resCode, DataBlog message) {
		super();
		this.resMsg = resMsg;
		this.resCode = resCode;
		this.message = message;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public DataBlog getMessage() {
		return message;
	}
	public void setMessage(DataBlog message) {
		this.message = message;
	}
	
	
}
