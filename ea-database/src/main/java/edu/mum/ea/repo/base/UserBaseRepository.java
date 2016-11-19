package edu.mum.ea.repo.base;

import org.springframework.data.repository.CrudRepository;

import edu.mum.ea.entity.User;

/**
 * http://blog.netgloo.com/2014/12/18/handling-entities-inheritance-with-spring-data-jpa/ 
 */

public interface UserBaseRepository<T extends User> extends CrudRepository<T, Integer> {

	
}
