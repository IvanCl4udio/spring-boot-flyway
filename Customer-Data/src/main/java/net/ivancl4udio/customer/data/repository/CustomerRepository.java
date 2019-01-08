package net.ivancl4udio.customer.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.ivancl4udio.customer.data.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
	
	Customer findByUsername(String username);
	
}
