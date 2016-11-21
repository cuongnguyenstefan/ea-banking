package edu.mum.ea.entity;

import javax.persistence.Entity;

@Entity
public class AccountSaving extends Account {

	private double interest;

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

}
