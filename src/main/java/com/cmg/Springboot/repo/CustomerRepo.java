package com.cmg.Springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmg.Springboot.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String>{
	

}
