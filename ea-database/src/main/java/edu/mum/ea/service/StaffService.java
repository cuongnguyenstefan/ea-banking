package edu.mum.ea.service;

import edu.mum.ea.entity.Request;
import edu.mum.ea.entity.Staff;

public interface StaffService {
	
	public boolean saveOrUpdate(Staff staff);
	
	public Staff getStaff(String username);
	
	public boolean approve(Staff staff, Request request);
	
}
