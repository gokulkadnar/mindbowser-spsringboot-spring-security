package com.mindbrowser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindbrowser.model.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer> {
	
	public Manager findByEmail(String email);
	
	public Manager findByPassword(String password);

	
	public Manager findByEmailAndPassword(String email,String password);


}
