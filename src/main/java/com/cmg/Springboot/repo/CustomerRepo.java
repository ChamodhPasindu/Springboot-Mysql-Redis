package com.cmg.Springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmg.Springboot.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>{
	

}
