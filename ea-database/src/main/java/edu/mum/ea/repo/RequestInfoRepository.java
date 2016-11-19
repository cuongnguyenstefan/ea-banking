package edu.mum.ea.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.RequestInfo;
import edu.mum.ea.repo.base.RequestBaseRepository;

@Repository
@Transactional
public interface RequestInfoRepository extends RequestBaseRepository<RequestInfo> {

}
