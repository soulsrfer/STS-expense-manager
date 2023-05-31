package com.ominMD.userService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ominMD.userService.entities.RoleEntity;
import com.ominMD.userService.repositories.RoleRepository;
import com.ominMD.userService.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepo;
	@Override
	public RoleEntity createRole(RoleEntity role) {
		roleRepo.save(role);
		return role;
	}

	@Override
	public RoleEntity readRole(String name) {	
		return roleRepo.findByName(name);
	}

}
