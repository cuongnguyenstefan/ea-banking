package edu.mum.ea.repo.base;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import edu.mum.ea.entity.Account;

@NoRepositoryBean
public interface AccountBaseRepository<T extends Account> extends CrudRepository<T, Integer> {

}
