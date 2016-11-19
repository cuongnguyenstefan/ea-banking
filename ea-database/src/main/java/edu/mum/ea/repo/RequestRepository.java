package edu.mum.ea.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.Request;

@Repository
@Transactional
public interface RequestRepository extends RequestBaseRepository<Request>{

}
