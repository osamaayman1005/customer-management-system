package com.deben.CustomerManagementSystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deben.CustomerManagementSystem.dto.CustomerDto;
import com.deben.CustomerManagementSystem.entity.Customer;
import com.deben.CustomerManagementSystem.repository.CustomerRepository;
import com.deben.CustomerManagementSystem.specification.CustomerSpecifications;
import com.deben.CustomerManagementSystem.specification.SearchCriteria;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceUnitTest {

	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerService customerService;
	
	@Test
	public void testGetCustomerById() {
		when(customerRepository.findByCustomerId(0, CustomerDto.class))
			.thenReturn(new CustomerDto("junit", "tester"));
		CustomerDto customer = customerService.getCustomerById(0);
		
		assertEquals("junit tester", customer.getFullName());
	}
	
	@Test
	public void testGetCustomerByLastName() {
		List<Customer> mockCustomers = new ArrayList<>();
		
		mockCustomers.add(new Customer("c1","junit","c1",null));
		mockCustomers.add(new Customer("c2","junit","c2",null));
		lenient().when(customerRepository.findAll(ArgumentMatchers.any(
				 CustomerSpecifications.class)
				))
				.thenReturn(mockCustomers);
		List<Customer> customers = customerService.getAllCustomerByLastName("junit");
		
		assertEquals(2,	customers.size());
		
		
	}
}
