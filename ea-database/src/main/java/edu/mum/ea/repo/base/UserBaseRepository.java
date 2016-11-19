package edu.mum.ea.repo.base;

import org.springframework.data.repository.CrudRepository;

import edu.mum.ea.entity.User;

public interface UserBaseRepository<T extends User> extends CrudRepository<T, Integer> {

}
