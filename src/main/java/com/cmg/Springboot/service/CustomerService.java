package com.cmg.Springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmg.Springboot.entity.Customer;
import com.cmg.Springboot.repo.CustomerRepo;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepo repo;

	public void saveCustomer(Customer customer) {
		if (!repo.existsById(customer.getId())) {
			repo.save(customer);
		} else {
			throw new RuntimeException("Customer Already Exist..!");
		}
	}

	public void deleteCustomer(String id) {
		System.out.println("Delete");
		if (repo.existsById(id)) {
			repo.deleteById(id);
		} else {
			throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
		}

	}

	public void updateCustomer(Customer customer) {
		System.out.println("update");
		if (repo.existsById(customer.getId())) {
			repo.save(customer);
		} else {
			throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
		}

	}

	public Customer searchCustomer(String id) {
		System.out.println("search");
		if (repo.existsById(id)) {
			return repo.findById(id).get();
		} else {
			throw new RuntimeException("No Customer For " + id + " ..!");
		}
	}

	public List<Customer> getAllCustomers() {
		System.out.println("get All");
		return repo.findAll();
	}

}
