package edu.mum.ea.repo;

import org.springframework.data.repository.CrudRepository;

import edu.mum.ea.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
