 package com.mindbrowser.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindbrowser.model.Manager;
import com.mindbrowser.repository.ManagerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	ManagerRepository managerRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			
			if(username==null) {
				username = "Hardik.pande@gmail.com";		

			}
			
			
			if(username !=null) {
				Manager  manager = managerRepo.findByEmail(username);
				
				UserDetails user = new User(manager.getEmail(), manager.getPassword(), new ArrayList<>());
				return user;
			}
//			if(username.equals("gokul"))
//			{
//				return new User("gokul","gokul",new ArrayList<>() );
//			}
			else
			{
				throw new UsernameNotFoundException("User Not found");
			}
			
	}
	
	
	

}
