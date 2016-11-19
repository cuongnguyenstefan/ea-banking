package edu.mum.ea.repo;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.Customer;
import edu.mum.ea.repo.base.UserBaseRepository;

@Repository
public interface CustomerRepository extends UserBaseRepository<Customer> {
	
}
