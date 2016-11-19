package edu.mum.ea.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.Account;
import edu.mum.ea.entity.AccountSaving;
import edu.mum.ea.repo.AccountRepository;
import edu.mum.ea.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService  {
	
	@Autowired
	private AccountRepository accountRepository;
	
	//Should return the account object after being withdraw or deposit

	@Override
	public Account withdraw(Account account, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account deposit(Account account, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account create(Account account) {
		AccountSaving s = new AccountSaving();
		s.setAmount(1000);
		accountRepository.save(s);
		return s;
	}
	
}
