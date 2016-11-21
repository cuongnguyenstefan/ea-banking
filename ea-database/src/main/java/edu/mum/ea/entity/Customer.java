package edu.mum.ea.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {
	    
		@OneToMany(mappedBy = "customer")
		private List<Account> account = new ArrayList<Account>();
    
		public List<Account> getAccount() {
			return account;
		}

		public void setAccount(List<Account> account) {
			this.account = account;
		}

		
}
