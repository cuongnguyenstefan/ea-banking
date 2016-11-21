package edu.mum.ea.service;

import edu.mum.ea.entity.Account;

public interface AccountService {
	
	public Account get(Integer id);
	
	public Account withdraw(Integer accountId, Double amount);
	
	public Account deposit(Integer accountId, Double amount);
	
	public Account create(Account account);
	
	
	
	

}
