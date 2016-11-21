package edu.mum.ea.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.StaffHistory;

@Repository
public interface StaffHistoryRepository extends CrudRepository<StaffHistory, Integer>{

}
