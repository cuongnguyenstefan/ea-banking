package edu.mum.ea.repo;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.AccountSaving;
import edu.mum.ea.repo.base.AccountBaseRepository;

@Repository
public interface AccountSavingRepository extends AccountBaseRepository<AccountSaving> {

}
