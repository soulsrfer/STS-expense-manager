package com.ominMD.userService.services;

import java.util.List;
import java.util.Map;

import com.ominMD.userService.entities.UserEntity;
import com.ominMD.userService.responses.UserResponse;

public interface UserServices {

	// add user
	UserEntity addUser(UserEntity userEntity);

	// get All user
	List<UserEntity> getAllUser();

	// get user by id
	UserEntity getUserById(Integer id);

	// delete user
	UserEntity deleteUserById(Integer id);

	// update user
	UserEntity updateUser(UserEntity userEntity);
	
	//convert object from UserEntity to ResponseEntity
	UserResponse entityToResponse(UserEntity user);
	
	Map<String, Object> getUserBalance(Integer userId);
}
