package com.mindbrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindbrowser.model.Manager;
import com.mindbrowser.model.ResultMessage;
import com.mindbrowser.model.User;
import com.mindbrowser.service.ManagerService;

@RestController
@CrossOrigin("*")
public class ManagerController {
	
	@Autowired
	ManagerService managerservice;
	
	@PostMapping("signup")
	public ResultMessage managerSignup(@RequestBody Manager managerTo){
		return managerservice.managerSignup(managerTo);
	}
	
	@PostMapping("login")
	public User managerLogin(@RequestBody User userTo){
		return managerservice.managerLogin(userTo);
	}
	

}
