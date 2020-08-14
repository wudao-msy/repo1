package com.zte.sms.entity.vo;

/**
 * 值对象，用于存放表单中的值，类似于formbean
 * @author hellboy
 *
 */
public class SysuserVO {
	
    private Integer id;
    
	private String username;
	
	private String password;
	
	private String newPass;
	
	
	

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	



}
