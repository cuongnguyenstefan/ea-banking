package edu.mum.ea.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.RequestInfo;

@Repository
@Transactional
public interface RequestInfoRepository extends RequestBaseRepository<RequestInfo> {

}
