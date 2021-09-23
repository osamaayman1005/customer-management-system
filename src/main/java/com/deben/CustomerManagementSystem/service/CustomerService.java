package com.deben.CustomerManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deben.CustomerManagementSystem.dto.CustomerDto;
import com.deben.CustomerManagementSystem.entity.CreditCard;
import com.deben.CustomerManagementSystem.entity.Customer;
import com.deben.CustomerManagementSystem.repository.CustomerRepository;
import com.deben.CustomerManagementSystem.specification.CustomerSpecifications;
import com.deben.CustomerManagementSystem.specification.SearchCriteria;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public CustomerDto getCustomerById(long id){

		return customerRepository.findByCustomerId(id, CustomerDto.class);
	}
	
	public Customer addNewCustomer(Customer newCustomer) {
		List<CreditCard> creditCards = newCustomer.getCreditCards();
		creditCards.forEach(creditCard->{
			creditCard.setCustomer(newCustomer);
		});
		newCustomer.setCreditCards(creditCards);
		return customerRepository.save(newCustomer);
	}
	
	public List<Customer> getAllCustomerByLastName(String lastName){

		List<Customer> customers = new ArrayList<Customer>();
		Iterable<Customer> result = customerRepository.findAll(new CustomerSpecifications(new SearchCriteria("lastName", ":", lastName)));
		result.forEach(customer->{
			customers.add(customer);
		});
		

		return customers;
	}
}
