package edu.mum.ea.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.Request;
@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {

}
