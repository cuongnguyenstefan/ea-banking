package edu.mum.ea.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.StaffHistory;
import edu.mum.ea.repo.StaffHistoryRepository;
import edu.mum.ea.service.StaffHistoryService;

@Service
@Transactional
public class StaffHistoryServiceImpl implements StaffHistoryService {

	@Autowired
	private StaffHistoryRepository staffHistoryRepo;
	
	@Override
	public void save(StaffHistory history) {
		staffHistoryRepo.save(history);
	}

	@Override
	public List<StaffHistory> findByStaffId(Integer id) {
		List<StaffHistory> findByStaffUsername = staffHistoryRepo.findByStaffUsername(id);
		for (StaffHistory sh : findByStaffUsername) {
			Hibernate.initialize(sh.getCustomer());
		}
		return findByStaffUsername;
	}

}
