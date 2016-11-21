package edu.mum.ea.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.Customer;
import edu.mum.ea.repo.CustomerRepository;
import edu.mum.ea.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
     
	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> findByName(String customerName) {
		// TODO Auto-generated method stub
//		return (List<Customer>) customerRepository.findByName(customerName);
		return null;
	}
	
	@Override
	public List<Customer> findByAccount(String customerAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
