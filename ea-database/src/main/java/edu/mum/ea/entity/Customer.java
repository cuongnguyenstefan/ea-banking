package edu.mum.ea.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {
		
		@OneToMany(mappedBy = "staff")
		private List<StaffHistory> histories = new ArrayList<StaffHistory>();

		public List<StaffHistory> getHistories() {
			return histories;
		}

		public void setHistories(List<StaffHistory> histories) {
			this.histories = histories;
		}
}
