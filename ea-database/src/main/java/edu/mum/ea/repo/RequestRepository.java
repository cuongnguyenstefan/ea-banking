package edu.mum.ea.repo;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.Request;
import edu.mum.ea.repo.base.RequestBaseRepository;

@Repository
public interface RequestRepository extends RequestBaseRepository<Request> {
	
}
