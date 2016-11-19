package edu.mum.ea.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {
		
		@OneToMany(mappedBy = "customer")
		private List<Account> accounts = new ArrayList<Account>();

		public List<Account> getAccounts() {
			return accounts;
		}

		public void setAccounts(List<Account> accounts) {
			this.accounts = accounts;
		}
}
