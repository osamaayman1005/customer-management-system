package com.deben.CustomerManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deben.CustomerManagementSystem.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>,JpaSpecificationExecutor<Customer> {
	<T> Iterable<T> findByLastName(String lastName, Class<T> type);
	<T> T findByCustomerId(long customerId,Class<T> type);
}
