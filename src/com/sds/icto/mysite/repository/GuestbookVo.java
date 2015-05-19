package com.sds.icto.mysite.repository;

public class GuestbookVo {
	private int no;
	private String name;
	private String password;
	private String message;
	private String regDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getregDate() {
		return regDate;
	}
	public void setregDate(String date) {
		regDate = date;
	}
	


}
