package com.ominMD.userService.services;

import java.util.List;

import com.ominMD.userService.entities.UserEntity;


public interface UserServices {

	//add user
	UserEntity addUser(UserEntity userEntity);
	
	//get All user
	List<UserEntity> getAllUser();
	
	//get user by id
	UserEntity getUserById(Integer id);
	
	//delete user 
	UserEntity deleteUserById(Integer id);
	
	//update user
	UserEntity updateUser(UserEntity userEntity);
}
