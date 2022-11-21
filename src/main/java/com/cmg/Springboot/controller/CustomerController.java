package com.cmg.Springboot.controller;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmg.Springboot.entity.Customer;
import com.cmg.Springboot.service.CustomerService;
import com.cmg.Springboot.util.ResponseUtil;

@RestController
@RequestMapping("controller/customer/")
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping(path = "allCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil getAllCustomer() {
		return new ResponseUtil(200, "Ok", service.getAllCustomers());
	}

	@GetMapping(path = "singleCustomer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Cacheable(value = "singleCustomer",key="#id")
	public ResponseUtil getCustomer(@PathVariable(value = "id") String id) {
		   return new ResponseUtil(200,"Ok",service.searchCustomer(id));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil addCustomer(@RequestBody Customer customer) {
		service.saveCustomer(customer);
		return new ResponseUtil(200, "Save", null);
	}

	@PutMapping(path = "update",produces = MediaType.APPLICATION_JSON_VALUE)
	@CachePut(value = "update")
	public ResponseUtil updateCustomer(@RequestBody Customer customer) {
		service.updateCustomer(customer);
		return new ResponseUtil(200, "Updated", null);
	}

	@DeleteMapping(path = "remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CacheEvict(value = "remove",allEntries = true)
	public ResponseUtil deleteCustomer(@PathVariable(value = "id") String id) {
		service.deleteCustomer(id);
		return new ResponseUtil(200, "Deleted", null);
	}

}
