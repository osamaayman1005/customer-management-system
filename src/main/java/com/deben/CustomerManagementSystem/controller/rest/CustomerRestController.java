package com.deben.CustomerManagementSystem.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deben.CustomerManagementSystem.dto.CustomerDto;
import com.deben.CustomerManagementSystem.entity.Customer;
import com.deben.CustomerManagementSystem.service.CustomerService;

@RestController
@RequestMapping(path="/api/customers")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	
//	@GetMapping
//	public List<CustomerDto> getAllCustomers() {
//		return customerService.getAllCustomers();
//	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addNewCustomer(customer);
	}
	
	@GetMapping(path = "/{id}")
	public CustomerDto getCustomer(@PathVariable(name="id") long customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@GetMapping(path = "/")
	public List<Customer> getCustomerByLastName(@RequestParam(name="lastName") String lastName) {
		return customerService.getAllCustomerByLastName(lastName);
	}
}
