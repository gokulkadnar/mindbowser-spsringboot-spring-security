package com.mindbrowser.model;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String email;
	private String password;
	private Manager manager;
	private String infoMsg;
	private int status;
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getInfoMsg() {
		return infoMsg;
	}
	public void setInfoMsg(String infoMsg) {
		this.infoMsg = infoMsg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

}
