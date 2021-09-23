package com.deben.CustomerManagementSystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deben.CustomerManagementSystem.dto.CreditCardDto;
import com.deben.CustomerManagementSystem.repository.CreditCardRepository;

@Service
public class CreditCardService {
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	public CreditCardDto getCreditCardById(long id){
		
		return 	creditCardRepository.findByCreditCardId(id, CreditCardDto.class);
	}

}
