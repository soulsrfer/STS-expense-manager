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
import com.ominMD.userService.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserServices userServices;
	
	
	@PostMapping("")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity){
		UserEntity user= userServices.addUser(userEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@GetMapping("")
	public ResponseEntity<List<UserEntity>> getAllUser(){
		List<UserEntity> users=userServices.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Integer id){
		UserEntity user=userServices.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<UserEntity> deleteUserById(@PathVariable("id") Integer id){
		UserEntity user=userServices.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PutMapping("")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity){
		UserEntity user=userServices.updateUser(userEntity);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
