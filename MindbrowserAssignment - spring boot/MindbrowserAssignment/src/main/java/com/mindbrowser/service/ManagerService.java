package com.mindbrowser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindbrowser.model.Manager;
import com.mindbrowser.model.ResultMessage;
import com.mindbrowser.model.User;
import com.mindbrowser.repository.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	ManagerRepository managerRepo;
	
	@Autowired
	ResultMessage resultMessage;
	
	@Autowired
	EncodeDecode encodeDecode;
	
	@Autowired
	User userInfo;
	
	public ResultMessage managerSignup(Manager managerTo){
		try {
			 
			// Encrypt the password before saving to database			
			String tempPassword =  encodeDecode.encodePassword(managerTo.getPassword());
			managerTo.setPassword(tempPassword);
			
			Manager tempManager = managerRepo.findByEmail(managerTo.getEmail());
			
			//Check email is already exist.
			if(tempManager !=null) {
				return resultMessage.error("email already registered",resultMessage);		
			}
			else 
			{
				tempManager =  managerRepo.save(managerTo);
				if(tempManager !=null) 
					return resultMessage.success("Manager successfully registred",resultMessage);
				else 
					return resultMessage.error("something went wrong",resultMessage);		

			}
			
		}
		catch (Exception e) {
			
			return resultMessage.error("Exception : Something wrong while adding details",resultMessage);		

		}
		
		
	}
	
	public User managerLogin(User userTo){
		Manager manager;

		
		try 
		{
			String tempPassword =  encodeDecode.encodePassword(userTo.getPassword());
			userTo.setPassword(tempPassword);
			
			manager = managerRepo.findByEmail(userTo.getEmail());
			
			//Check whether email is exist or not
			if(manager == null) 
			{
				userInfo.setInfoMsg("Email address does not exist");
				userInfo.setStatus(0);
				return userInfo;
			}
			
			manager = managerRepo.findByEmailAndPassword(userTo.getEmail(), userTo.getPassword());

			if(manager != null)
			{
				userInfo.setManager(manager);
				userInfo.setInfoMsg("User logged in successfully");
				userInfo.setStatus(1);
				 return userInfo;
				
			}
			
			else 
			{
				userInfo.setInfoMsg("Password is incorrect");
				return userInfo;
			}

		}
		
		catch (Exception e)
		{
			userInfo.setInfoMsg("Exception : Something went wrong");
			 return userInfo;
		}
		
}


}
