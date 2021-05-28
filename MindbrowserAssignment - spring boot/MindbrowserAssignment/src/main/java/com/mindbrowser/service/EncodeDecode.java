package com.mindbrowser.service;

import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class EncodeDecode {
	
	public String encodePassword(String password) {
		
		String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		
//		byte [] strasByte  = Base64.getDecoder().decode(encryptedPassword);
		
		return  encryptedPassword;
		
	}

}
