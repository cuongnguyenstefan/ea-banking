package edu.mum.ea.service;

import java.util.List;

import edu.mum.ea.entity.Customer;

public interface CustomerService {

	public Customer save(Customer customer);

	public Customer findById(Integer userName );
	
	public List<Customer> findAll();
}
