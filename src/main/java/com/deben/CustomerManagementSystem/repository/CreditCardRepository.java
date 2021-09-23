package com.deben.CustomerManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deben.CustomerManagementSystem.entity.CreditCard;
import com.deben.CustomerManagementSystem.entity.Customer;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long>{
	<T> T findByCreditCardId(long creditCardId,Class<T> type);
}
