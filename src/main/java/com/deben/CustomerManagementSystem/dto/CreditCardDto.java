package com.deben.CustomerManagementSystem.dto;

import java.util.Date;

public class CreditCardDto {

	public String hiddenNumber;
	public Date expirationDate;
	
	public CreditCardDto(String number,Date expirationDate) {
		this.hiddenNumber = "************"+number.substring(number.length()-4);
		this.expirationDate = expirationDate;
	}

	public String getHiddenNumber() {
		return hiddenNumber;
	}

	public void setHiddenNumber(String hiddenNumber) {
		this.hiddenNumber = hiddenNumber;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
