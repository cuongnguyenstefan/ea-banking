package edu.mum.ea.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.entity.UserRoles;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRoles, Integer>{

}
