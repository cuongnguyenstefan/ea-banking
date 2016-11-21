package edu.mum.ea.service;

import java.util.List;

import edu.mum.ea.entity.StaffHistory;

public interface StaffHistoryService {

	public void save(StaffHistory history);
	
	public List<StaffHistory> findByStaffId(Integer id);
	
}
