package com.ominMD.userService.services;

import com.ominMD.userService.entities.RoleEntity;

public interface RoleService {
	
	//create role
	RoleEntity createRole(RoleEntity role);
	
	//read role
	RoleEntity readRole(String name);
}
