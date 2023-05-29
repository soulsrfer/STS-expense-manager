package com.ominMD.userService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ominMD.userService.entities.UserEntity;
import com.ominMD.userService.excaptions.ResourceNotFoundExcaption;
import com.ominMD.userService.repositories.UserRepository;
import com.ominMD.userService.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserEntity addUser(UserEntity userEntity) {
		UserEntity user=userRepository.save(userEntity);
		return user;
	}
	
	@Override
	public List<UserEntity> getAllUser() {
 	    List<UserEntity> users=userRepository.findAll();
		return users;
	}
	
	@Override
	public UserEntity getUserById(Integer id) {
		UserEntity user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcaption("user in not found for this id :"+id));
		return user;
	}
	
	@Override
	public UserEntity deleteUserById(Integer id) {
		UserEntity user=userRepository.findById(id).get();
		userRepository.deleteById(id);
		return user;
	}
	
	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		UserEntity user=userRepository.save(userEntity);
		return user;
	}

}
