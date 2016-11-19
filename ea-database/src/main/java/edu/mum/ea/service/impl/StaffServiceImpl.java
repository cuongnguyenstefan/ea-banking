package edu.mum.ea.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.mum.ea.entity.Request;
import edu.mum.ea.entity.Staff;
import edu.mum.ea.service.StaffService;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

	@Override
	public boolean saveOrUpdate(Staff staff) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Staff getStaff(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approve(Staff staff, Request request) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
