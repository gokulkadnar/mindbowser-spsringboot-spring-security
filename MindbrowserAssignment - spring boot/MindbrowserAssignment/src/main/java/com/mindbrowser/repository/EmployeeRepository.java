package com.mindbrowser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindbrowser.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
