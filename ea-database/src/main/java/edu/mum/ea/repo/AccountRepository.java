package edu.mum.ea.repo;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.Account;
import edu.mum.ea.repo.base.AccountBaseRepository;

@Repository
public interface AccountRepository extends AccountBaseRepository<Account> {

}
