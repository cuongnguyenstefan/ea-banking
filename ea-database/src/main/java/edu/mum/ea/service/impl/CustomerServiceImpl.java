package edu.mum.ea.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
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
	public Customer save(Customer customer) {
		Customer save = customerRepository.save(customer);
		return save;
		
	}

	
	@Override
	public List<Customer> findAll() {
		 
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer findById(Integer userName) {
		Customer findOne = customerRepository.findOne(userName);
		Hibernate.initialize(findOne.getAccount());
		return findOne;
	}


}
