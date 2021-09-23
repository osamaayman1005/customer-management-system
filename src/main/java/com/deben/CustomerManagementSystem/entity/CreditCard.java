package com.deben.CustomerManagementSystem.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {
	@Id
	@Column(name = "CREDIT_CARD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long creditCardId;
	@Column(name = "EXPIRATION_DATE")
	private Date expirationDate;
	@Column(name = "NUMBER",length = 16)
	private String number;
	@Column(name = "CVV")
	private String cvv;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CUSTOMER_ID")
	@JsonIgnore
	private Customer customer;

	public CreditCard() {}
	public CreditCard(Date expirationDate, String number, String cvv, Customer customer) {
		super();
		this.expirationDate = expirationDate;
		this.number = number;
		this.cvv = cvv;
		this.customer = customer;
	}

	public long getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
