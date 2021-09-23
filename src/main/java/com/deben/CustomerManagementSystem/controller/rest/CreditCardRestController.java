package com.deben.CustomerManagementSystem.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deben.CustomerManagementSystem.dto.CreditCardDto;
import com.deben.CustomerManagementSystem.service.CreditCardService;

@RestController
@RequestMapping(path="/api/credit-cards")
public class CreditCardRestController {
	
	@Autowired
	private CreditCardService creditCardService;
	@GetMapping(path = "/{id}")
	public CreditCardDto getCreditCard(@PathVariable(name="id") long creditCardId) {
		return creditCardService.getCreditCardById(creditCardId);
	}
}
