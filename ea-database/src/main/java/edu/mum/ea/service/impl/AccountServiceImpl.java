package edu.mum.ea.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.Account;
import edu.mum.ea.entity.User;
import edu.mum.ea.repo.AccountRepository;
import edu.mum.ea.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	// Should return the account object after being withdraw or deposit

	@Override
	public Account withdraw(Integer accountId, Double amount) {
		Account account = accountRepository.findOne(accountId);
		account.setAmount(account.getAmount() - amount);
		accountRepository.save(account);
		return account;
	}

	@Override
	public Account deposit(Integer accountId, Double amount) {

		Account account = accountRepository.findOne(accountId);
		account.setAmount(account.getAmount() + amount);
		accountRepository.save(account);
		return account;
	}

	@Override
	public Account create(Account account) {
		accountRepository.save(account);
		return account;
	}



	@Override
	public Account get(Integer id) {
		 Account a = accountRepository.findOne(id);
		
		return a ;
	}

	

	

	

	

}
