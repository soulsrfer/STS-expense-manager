package com.ominMD.userService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ominMD.userService.entities.RoleEntity;
import com.ominMD.userService.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	
	@Autowired
	RoleService roleService;
	
	@PostMapping
	public ResponseEntity<RoleEntity> createRole(@RequestBody RoleEntity role) {
		
		RoleEntity role1 = roleService.createRole(role);
		
		return ResponseEntity.status(HttpStatus.OK).body(role1);
	}
	
	@GetMapping
	public ResponseEntity<RoleEntity> findRoleByName(@PathVariable String roleName) {
		RoleEntity role = roleService.readRole(roleName);
		
		return ResponseEntity.status(HttpStatus.OK).body(role);
	} 
	
	
}
