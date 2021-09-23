package com.deben.CustomerManagementSystem.service;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.hasProperty;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.beans.HasPropertyWithValue;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.deben.CustomerManagementSystem.dto.CustomerDto;
import com.deben.CustomerManagementSystem.entity.Customer;


@SpringBootTest(webEnvironment  = WebEnvironment.NONE)
public class CustomerServiceIntegrationTest {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void testGetCustomerById() {
		CustomerDto customer = customerService.getCustomerById(1);
		assertEquals("osama ayman", customer.getFullName());
	}
	
	@Test
	public void testGetCustomerByLastName() {
		List<Customer> customers = customerService.getAllCustomerByLastName("ayman");
		
		assertTrue(customers.size()>=1);
		
		assertThat(
				customers,
				everyItem(
						Matchers.<Customer>hasProperty("lastName",is("ayman"))
						)
				);
		assertThat(customers,
				hasItem(
						Matchers.<Customer>hasProperty("firstName",is("osama"))
						)
				);
	}
}
