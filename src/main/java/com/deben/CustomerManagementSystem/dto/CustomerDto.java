package com.deben.CustomerManagementSystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.deben.CustomerManagementSystem.entity.CreditCard;

public class CustomerDto {

	private String fullName;
	//private List<CreditCardDto> creditCards = new ArrayList<CreditCardDto>();
	
	public CustomerDto(String firstName,String lastName
			//,List<CreditCard>creditCards
			) {
		this.fullName = firstName + " " + lastName;
		//creditCards.forEach(creditCard->{
			//this.creditCards.add(new CreditCardDto(creditCard.getNumber(), creditCard.getExpirationDate()));
		//});
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
