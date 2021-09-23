package com.deben.CustomerManagementSystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deben.CustomerManagementSystem.dto.CreditCardDto;
import com.deben.CustomerManagementSystem.dto.CustomerDto;
import com.deben.CustomerManagementSystem.repository.CreditCardRepository;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceUnitTest {

	@Mock
	CreditCardRepository creditCardRepository;
	@InjectMocks
	CreditCardService creditCardService;
	
	@Test
	public void testGetCreditCardById() {
		
		when(creditCardRepository.findByCreditCardId(0, CreditCardDto.class))
		.thenReturn(new CreditCardDto("************1234", null));
	CreditCardDto creditCard = creditCardService.getCreditCardById(0);
	
	assertEquals("************1234", creditCard.getHiddenNumber());
	}
}
