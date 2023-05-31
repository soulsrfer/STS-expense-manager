package com.ominMD.expenseService.services;

import java.util.List;

import com.ominMD.expenseService.entities.ExpenseEntity;


public interface ExpenseService {
	
	//create expense
	ExpenseEntity createExpense(ExpenseEntity expense);
	
	//get expense by id
	ExpenseEntity getExpenseById(Integer expenseId);
	
	//get all expenses
	List<ExpenseEntity> getAllExpenses();
	
	//get all expenses by user id
	List<ExpenseEntity> getExpensesByUserId(Integer userId);
	
	//update expense by id 
	ExpenseEntity updateExpense(ExpenseEntity expense);
	
	//delete expense by id
	ExpenseEntity deleteExpense(Integer expenseId);
	
	//get all expenses by user id
	List<ExpenseEntity> getAllExpensesByUserId(Integer userId);
}
