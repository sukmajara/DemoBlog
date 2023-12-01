package com.demo.Blog.DTO;


public class ResponseGetDetailDTO {
	String resCode;
	String resMsg;
	DataBlog message;
	
	public ResponseGetDetailDTO() {
		super();
	}
	public ResponseGetDetailDTO(String resCode, String resMsg, DataBlog message) {
		super();
		this.resCode = resCode;
		this.resMsg = resMsg;
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
	public DataBlog getMessage() {
		return message;
	}
	public void setMessage(DataBlog message) {
		this.message = message;
	}
	
	
	
	
}
