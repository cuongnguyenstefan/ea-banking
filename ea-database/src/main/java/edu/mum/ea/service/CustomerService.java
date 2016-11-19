package edu.mum.ea.service;

import java.util.List;

import edu.mum.ea.entity.Customer;

public interface CustomerService {

	public void save(Customer customer);

	public List<Customer> findByName(String customerName);

	public List<Customer> findByAccount(String customerAccount);
}
