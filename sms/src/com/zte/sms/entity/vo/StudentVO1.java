package com.zte.sms.entity.vo;



public class StudentVO1 {
	
	private Integer sid;
	
	private String username;
	
	private String password;
	
	
	
	public StudentVO1() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "StudentVO1 [username=" + username + ", password=" + password + "]";
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



	public Integer getSid() {
		return sid;
	}



	public void setSid(Integer sid) {
		this.sid = sid;
	}

	
	
	
	
	
	
	
	
	

}
