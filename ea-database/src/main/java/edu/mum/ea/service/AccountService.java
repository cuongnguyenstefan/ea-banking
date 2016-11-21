package edu.mum.ea.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.ea.entity.Account;
import edu.mum.ea.entity.User;
import edu.mum.ea.repo.AccountRepository;
import edu.mum.ea.repo.base.UserBaseRepository;

public interface AccountService {
	
	
	
	public Account withdraw(Integer accountId, Double amount);
	
	public Account deposit(Integer accountId, Double amount);
	
	public Account create(Account account);
	
	public Account findAllAccount(Account account);
	
	

}
