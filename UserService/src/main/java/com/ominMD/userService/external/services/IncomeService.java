package com.ominMD.userService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ominMD.userService.dto.Income;

@FeignClient(name = "INCOME-SERVICE")
public interface IncomeService {
	
	@GetMapping("/incomes/incomeList/{userId}")
	List<Income> getIncomeListByUser(@PathVariable("userId") Integer userId);
	
	
	@GetMapping("/incomes/totalIncome/{userId}")
	double getTotalIncomeOfUser(@PathVariable("userId")Integer userId);

}
