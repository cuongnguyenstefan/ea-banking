package edu.mum.ea.service;

import java.util.List;

import edu.mum.ea.entity.Customer;

public interface CustomerService {

	public void save(Customer customer);

	public List<Customer> findByName(String customerName);

	public Customer findById(Integer userName );
	
	public List<Customer> findAll();
}
