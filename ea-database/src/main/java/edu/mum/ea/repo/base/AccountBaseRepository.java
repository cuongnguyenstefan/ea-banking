package edu.mum.ea.repo.base;

import org.springframework.data.repository.CrudRepository;

import edu.mum.ea.entity.Account;

public interface AccountBaseRepository<T extends Account> extends CrudRepository<T, Integer> {

}
