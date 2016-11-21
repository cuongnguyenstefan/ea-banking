package edu.mum.ea.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.AccountSaving;
import edu.mum.ea.repo.AccountSavingRepository;

@Service

public class Scheduler {

	@Autowired
	AccountSavingRepository accountSavingRepo;
	
	@Scheduled(cron="0 0/5 * * * ?")
	public void savingAccount()
	{
		System.out.println("updating accounts");
		Iterable<AccountSaving> accounts =accountSavingRepo.findAll();
		for(AccountSaving accountsaving: accounts)
		{	double account = accountsaving.getAmount();
			double interest = accountsaving.getInterest();
			double accountNew =account + account * interest / 100;
			accountsaving.setAmount(accountNew);
		}
		accountSavingRepo.save(accounts);
	}
}
