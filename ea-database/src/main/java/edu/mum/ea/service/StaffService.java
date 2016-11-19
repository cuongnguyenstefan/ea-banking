package edu.mum.ea.service;

import edu.mum.ea.entity.Staff;

public interface StaffService {
	
	public boolean saveOrUpdate(Staff staff);
	
	public Staff getStaff(Integer username);
	
	public void approve(Integer staff, Integer request, boolean approve);
	
}
