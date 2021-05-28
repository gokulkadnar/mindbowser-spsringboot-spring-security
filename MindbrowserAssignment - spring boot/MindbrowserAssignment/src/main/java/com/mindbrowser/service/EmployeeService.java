package com.mindbrowser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindbrowser.model.Employee;
import com.mindbrowser.model.ResultMessage;
import com.mindbrowser.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	ResultMessage resultMessage;
	
	//Get all employee list
	public List<Employee> getEmployeeList(){
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeRepo.findAll().forEach(emp -> employeeList.add(emp));
		return employeeList;
		
	}
	
	
	public ResultMessage saveOrUpdateEmployee(Employee employeeTo){
		
		try
		{
			Employee tempEmp =  employeeRepo.save(employeeTo);
			
			if(tempEmp !=null)
			{
				return resultMessage.success("record save successfully",resultMessage);
			}
			else 
			{
				return resultMessage.error("error occured while saving record",resultMessage);
			}

		}
		
		catch(Exception e)
		{
			return resultMessage.error("Exception : while inserting employee record",resultMessage);
		}
		
	}
	
	
	//	Delete employee by Id
	public ResultMessage deleteEmployee(int id){
		try
		{
			employeeRepo.deleteById(id);
			return resultMessage.success("record deleted successfully",resultMessage);
		}
		
		catch (Exception e) 
		{
			return resultMessage.error(" Exception : Error occured while deleting record",resultMessage);
		}
	}
	
	
	//Find employee by id
	public Employee findEmployee(int id){
		
		return employeeRepo.findById(id).get();
	}


}
