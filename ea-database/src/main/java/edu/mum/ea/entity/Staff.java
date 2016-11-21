package edu.mum.ea.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Staff extends User {
	
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<StaffHistory> histories = new ArrayList<StaffHistory>();

	public List<StaffHistory> getHistories() {
		return histories;
	}

	public void setHistories(List<StaffHistory> histories) {
		this.histories = histories;
	}
	
}
