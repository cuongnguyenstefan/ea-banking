package edu.mum.ea.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.ea.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	@Query("select r from Resource  r where r.firstName= :name")
	public List<Customer> findByName(@Param("name") String customerName);
	
	@SuppressWarnings("unchecked")
	Customer save(Customer customer);
    
}
