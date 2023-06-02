package com.ominMD.userService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ominMD.userService.dto.Expense;

@FeignClient(name = "EXPENSE-SERVICE")
public interface ExpenseService {

	@GetMapping("/expenses/user/{userId}")
	List<Expense> getExpensesByUser(@PathVariable("userId") Integer userId);
}
