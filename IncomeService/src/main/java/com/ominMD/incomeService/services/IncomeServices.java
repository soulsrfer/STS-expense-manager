package com.ominMD.incomeService.services;

import java.util.List;

import com.ominMD.incomeService.entities.IncomeEntity;

public interface IncomeServices {

	//create income
	IncomeEntity createIncome(IncomeEntity incomeEntity);
	
	//get All income
	List<IncomeEntity> getAllIncome();
	
	//get All income by userid
	List<IncomeEntity> getAllIncomeByUserId(int userId);
	
	//get income by id
	IncomeEntity getIncomeByid(Integer id);
	
	//delete income 
	IncomeEntity deleteIncomeById(Integer id);
	
	//update income
	IncomeEntity updateIncome(IncomeEntity incomeEntity);
	
	//delete all incomes by userId
	List<IncomeEntity> deleteAllIncomeByUser(Integer UserId); 
	
	//get total income of user
	double getTotalIncomeOfUser(Integer userId);
}
