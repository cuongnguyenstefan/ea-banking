package edu.mum.ea.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.RequestAccount;

@Repository
@Transactional
public interface RequestAccountRepository extends RequestBaseRepository<RequestAccount>{

}
