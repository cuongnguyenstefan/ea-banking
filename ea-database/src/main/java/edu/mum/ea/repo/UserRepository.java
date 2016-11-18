package edu.mum.ea.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
