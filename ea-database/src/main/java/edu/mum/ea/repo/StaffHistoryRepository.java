package edu.mum.ea.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.StaffHistory;

@Repository
public interface StaffHistoryRepository extends CrudRepository<StaffHistory, Integer> {

	public List<StaffHistory> findByStaffUsername(Integer username);
	
}
