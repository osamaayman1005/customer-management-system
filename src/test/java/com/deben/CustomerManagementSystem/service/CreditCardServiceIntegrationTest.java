package com.deben.CustomerManagementSystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.deben.CustomerManagementSystem.dto.CreditCardDto;

@SpringBootTest(webEnvironment  = WebEnvironment.NONE)
public class CreditCardServiceIntegrationTest {

	@Autowired
	CreditCardService creditCardService;
	
	@Test
	public void testGetCreditCardById() {
		CreditCardDto creditCard = creditCardService.getCreditCardById(1);
		assertEquals("************3456", creditCard.getHiddenNumber());
	}
	
}
