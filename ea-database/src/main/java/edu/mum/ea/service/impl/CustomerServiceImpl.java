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
	public List<Customer> findByName(String customerName) {
		// TODO Auto-generated method stub
//		return (List<Customer>) customerRepository.findByName(customerName);
		return null;
	}
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(Integer userName) {
		Customer findOne = customerRepository.findOne(userName);
		Hibernate.initialize(findOne.getAccount());
		return findOne;
	}


}
