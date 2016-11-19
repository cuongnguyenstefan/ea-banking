package edu.mum.ea.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import edu.mum.ea.entity.Request;

@NoRepositoryBean
public interface RequestBaseRepository<T extends Request> extends CrudRepository<T, Integer> {

}
