package edu.mum.ea.repo;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.Staff;
import edu.mum.ea.repo.base.UserBaseRepository;

@Repository
public interface StaffRepository extends UserBaseRepository<Staff> {
	
	

}
