package edu.mum.ea.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.entity.UserRoles;
import edu.mum.ea.repo.UserRolesRepository;
import edu.mum.ea.service.UserRolesService;

@Service
@Transactional
public class UserRolesServiceImpl implements UserRolesService {

	@Autowired
	private UserRolesRepository userRolesRepo;
	
	@Override
	public UserRoles save(UserRoles userRoles) {
		UserRoles save = userRolesRepo.save(userRoles);
		return save;
	}

}
