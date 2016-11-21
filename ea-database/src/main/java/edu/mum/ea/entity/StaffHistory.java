package edu.mum.ea.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.ea.entity.enumtype.RequestType;

@Entity
public class StaffHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int historyId;
	
	@ManyToOne
	@JoinColumn(name = "staffId")
	private Staff staff;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private RequestType requestType;
	
	private String action;
	
	private boolean approved;

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	
}
