package com.demo.Blog.DTO;

public class ResponseErrorDTO {
	String resCode;
	String resMsg;
	
	public ResponseErrorDTO() {
		super();
	}
	public ResponseErrorDTO(String resCode, String resMsg) {
		super();
		this.resCode = resCode;
		this.resMsg = resMsg;
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
	
	
}
