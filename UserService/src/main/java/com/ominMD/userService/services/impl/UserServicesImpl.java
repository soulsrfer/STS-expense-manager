package com.ominMD.userService.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ominMD.userService.constants.RoleConstants;
import com.ominMD.userService.dto.Expense;
import com.ominMD.userService.dto.Income;
import com.ominMD.userService.entities.UserEntity;
import com.ominMD.userService.excaptions.ResourceNotFoundExcaption;
import com.ominMD.userService.repositories.RoleRepository;
import com.ominMD.userService.repositories.UserRepository;
import com.ominMD.userService.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public UserEntity addUser(UserEntity userEntity) {
//		UserEntity user=userRepository.save(userEntity);
		userEntity.setRole(roleRepo.findByName(RoleConstants.USER_ROLE));
		userRepository.save(userEntity);
		return userEntity;
	}
	
	@Override
	public List<UserEntity> getAllUser() {
 	    List<UserEntity> users=userRepository.findAll();
		return users;
	}
	
	@Override
	public UserEntity getUserById(Integer id) {
		UserEntity user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcaption("user in not found for this id :"+id));
		List<Expense> expenses = (restTemplate.getForObject("http://localhost:8082/expenses/user/" +id, List.class));
		List<Income> incomes = (restTemplate.getForObject("http://localhost:8083/incomes/user/" + id, List.class));
		user.setExpenses(expenses);
		user.setIncomes(incomes);
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
