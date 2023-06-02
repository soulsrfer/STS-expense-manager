package com.ominMD.userService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ominMD.userService.entities.UserEntity;
import com.ominMD.userService.repositories.UserRepository;
import com.ominMD.userService.responses.UserResponse;
import com.ominMD.userService.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServices userServices;
	
	@Autowired
	UserRepository userRepo;

	@PostMapping("")
	public ResponseEntity<UserResponse> addUser(@RequestBody UserEntity userEntity) {
		UserEntity user = userServices.addUser(userEntity);
		
		if(user.getRole() == null) {
			userRepo.delete(user);
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
		UserResponse response = userServices.entityToResponse(user);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("")
	public ResponseEntity<List<UserEntity>> getAllUser() {
		List<UserEntity> users = userServices.getAllUser();
		
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Integer id) {
		UserEntity user = userServices.getUserById(id);
		UserResponse response = userServices.entityToResponse(user);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<UserEntity> deleteUserById(@PathVariable("id") Integer id) {
		UserEntity user = userServices.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PutMapping("")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity) {
		UserEntity user = userServices.updateUser(userEntity);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
