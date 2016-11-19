package edu.mum.ea.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.Request;
import edu.mum.ea.repo.base.RequestBaseRepository;

@Repository
@Transactional
public interface RequestRepository extends RequestBaseRepository<Request>{

}
