package com.ominMD.userService.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ominMD.userService.constants.RoleConstants;
import com.ominMD.userService.dto.Expense;
import com.ominMD.userService.dto.Income;
import com.ominMD.userService.entities.UserEntity;
import com.ominMD.userService.excaptions.ResourceNotFoundExcaption;
import com.ominMD.userService.external.services.ExpenseService;
import com.ominMD.userService.repositories.RoleRepository;
import com.ominMD.userService.repositories.UserRepository;
import com.ominMD.userService.responses.UserResponse;
import com.ominMD.userService.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ExpenseService expenseService;

	@Override
	public UserEntity addUser(UserEntity userEntity) {
//		UserEntity user=userRepository.save(userEntity);
		userEntity.setRole(roleRepo.findByName(RoleConstants.USER_ROLE));
		userRepository.save(userEntity);
		return userEntity;
	}

	@Override
	public List<UserEntity> getAllUser() {
		List<UserEntity> users = userRepository.findAll();
		return users;
	}

	@Override
	public UserEntity getUserById(Integer id) {
		UserEntity user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcaption("user in not found for this id :" + id));

//		List<Expense> expenses = (restTemplate.getForObject("http://EXPENSE-SERVICE/expenses/user/" +id, List.class));
		List<Expense> expenses = expenseService.getExpensesByUser(id);

		List<Income> incomes = (restTemplate.getForObject("http://INCOME-SERVICE/incomes/user/" + id, List.class));
		user.setExpenses(expenses);
		user.setIncomes(incomes);
		return user;
	}

	@Override
	public UserEntity deleteUserById(Integer id) {
		UserEntity user = userRepository.findById(id).get();
		userRepository.deleteById(id);
		return user;
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		UserEntity user = userRepository.save(userEntity);
		return user;
	}

	@Override
	public UserResponse entityToResponse(UserEntity user) {
		UserResponse response = UserResponse.builder().
				id(user.getId())
				.firstName(user
				.getFirstName())
				.lastName(user.getLastName())
				.contact(user.getContact())
				.email(user.getEmail())
				.role(user.getRole().getName())
				.expenses(user.getExpenses())
				.incomes(user.getIncomes())
				.build();
		return response;
	}

	@Override
	public Map<String, Object> getUserBalance(Integer userId) {
		
		return null;
	}

}
