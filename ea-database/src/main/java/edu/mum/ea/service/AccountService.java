package edu.mum.ea.service;

import edu.mum.ea.entity.Account;

public interface AccountService {
	
	public Account withdraw(Account account, Double amount);
	
	public Account deposit(Account account, Double amount);
	
	public Account create(Account account);

	public double withdraw();
	
	public double deposit();
}
