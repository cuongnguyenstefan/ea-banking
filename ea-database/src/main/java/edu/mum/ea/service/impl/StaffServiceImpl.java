package edu.mum.ea.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.Customer;
import edu.mum.ea.entity.Request;
import edu.mum.ea.entity.RequestAccount;
import edu.mum.ea.entity.Staff;
import edu.mum.ea.entity.StaffHistory;
import edu.mum.ea.entity.enumtype.RequestStatus;
import edu.mum.ea.entity.enumtype.RequestType;
import edu.mum.ea.repo.StaffRepository;
import edu.mum.ea.service.RequestService;
import edu.mum.ea.service.StaffService;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private RequestService requestService;

	@Override
	public boolean saveOrUpdate(Staff staff) {
		staffRepository.save(staff);
		return false;
	}

	@Override
	public Staff getStaff(Integer username) {
		Staff staff = staffRepository.findOne(username);
		Hibernate.initialize(staff.getHistories());
		return staff;
	}

	@Override
	public void approve(Integer staff, Integer request, boolean approve) {
		Staff staffApprove = staffRepository.findOne(staff);
		Request requestApprove = requestService.get(request);
		
		// create a approval history
		StaffHistory history = new StaffHistory();
		history.setApproved(approve);
		history.setCreatedOn(new Date());
		Customer customer = requestApprove.getCustomer();
		history.setCustomer(customer);
		history.setStaff(staffApprove);
		if (requestApprove instanceof RequestAccount) {
			history.setRequestType(RequestType.REQUEST_ACCOUNT);
			if (approve) {
				history.setAction("Approved creating new account on customer: " + customer.getUsername());
			} else {
				history.setAction("Disapproved creating new account on customer: " + customer.getUsername());
			}
		} else {
			history.setRequestType(RequestType.CHANGE_INFO);
			if (approve) {
				history.setAction("Approved changing info on customer: " + customer.getUsername());
			} else {
				history.setAction("Disapproved changing info on customer: " + customer.getUsername());
			}
		}
		List<StaffHistory> histories = staffApprove.getHistories();
		histories.add(history);
		staffApprove.setHistories(histories);
		staffRepository.save(staffApprove);
		
		//update request
		if (approve) {
			requestApprove.setRequestStatus(RequestStatus.APPROVED);
		} else {
			requestApprove.setRequestStatus(RequestStatus.DISAPPROVED);
		}
		requestService.saveOrUpdate(requestApprove);
	}
	
}
