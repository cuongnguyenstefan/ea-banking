package edu.mum.ea.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.mum.ea.entity.Account;
import edu.mum.ea.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService  {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double withdraw() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposit() {
		// TODO Auto-generated method stub
		return 0;
	}

}
