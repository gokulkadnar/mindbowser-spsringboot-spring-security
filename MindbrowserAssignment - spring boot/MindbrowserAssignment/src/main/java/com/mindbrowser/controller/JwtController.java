package com.mindbrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindbrowser.jwt.JwtUtil;
import com.mindbrowser.model.JwtResponse;
import com.mindbrowser.model.JwtToken;
import com.mindbrowser.service.CustomUserDetailsService;

@CrossOrigin("*")
@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("token")
	public ResponseEntity<?> gerenateToken(@RequestBody JwtToken jwtToken) throws Exception {
		
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtToken.getEmail(), jwtToken.getPassword()));
		}
		
		catch (UsernameNotFoundException e) {
			
				throw new Exception("User not found");
		}
		catch (BadCredentialsException e) 
		{
			throw new Exception("User not found");
		}
		
		
		UserDetails userDetails =  this.customUserDetailsService.loadUserByUsername(jwtToken.getEmail());
		
		String token = this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
