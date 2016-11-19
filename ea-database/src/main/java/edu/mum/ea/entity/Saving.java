package edu.mum.ea.entity;

import javax.persistence.Entity;

@Entity
public class Saving extends Account {

	private double interest;

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	private double deposit() {
		return getAmount() + getInterest() * getAmount();
	}

}
