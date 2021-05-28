package com.mindbrowser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindbrowser.model.Employee;
import com.mindbrowser.model.ResultMessage;
import com.mindbrowser.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("employees")
	public List<Employee> getEmployeeList(){
		return employeeService.getEmployeeList();
	}
	
	@PostMapping("save")
	public ResultMessage saveEmployee(@RequestBody Employee employeeTo){
		
		return employeeService.saveOrUpdateEmployee(employeeTo);
	}
	
	@PutMapping("update")
	public ResultMessage updateEmployee(@RequestBody Employee employeeTo){
		return employeeService.saveOrUpdateEmployee(employeeTo);
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResultMessage deleteEmployee(@PathVariable ("id") int id){
		return employeeService.deleteEmployee(id);
		
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmployee(@PathVariable ("id") int id){
		return employeeService.findEmployee(id);
		
	}


}
