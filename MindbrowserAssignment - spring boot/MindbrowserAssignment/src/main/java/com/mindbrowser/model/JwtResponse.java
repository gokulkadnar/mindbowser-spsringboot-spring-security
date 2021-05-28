package com.mindbrowser.model;

public class JwtResponse {
	
	String token;

	public JwtResponse(String token2) {
		this.token = token2;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
