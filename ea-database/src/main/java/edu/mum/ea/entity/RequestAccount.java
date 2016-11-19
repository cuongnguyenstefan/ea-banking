package edu.mum.ea.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import edu.mum.ea.entity.enumtype.AccountType;
import edu.mum.ea.entity.enumtype.RequestType;

@Entity
@DiscriminatorValue(value = RequestType.Values.REQUEST_ACCOUNT)
public class RequestAccount extends Request{
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
}
