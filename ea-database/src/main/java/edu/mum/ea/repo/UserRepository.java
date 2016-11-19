package edu.mum.ea.repo;

import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.User;
import edu.mum.ea.repo.base.UserBaseRepository;

@Repository
public interface UserRepository extends UserBaseRepository<User> {

}
