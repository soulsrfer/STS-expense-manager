package com.ominMD.expenseService.services.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ominMD.expenseService.entities.ExpenseEntity;
import com.ominMD.expenseService.exceptions.ResourceNotFoundException;
import com.ominMD.expenseService.repositories.ExpenseRepository;
import com.ominMD.expenseService.services.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepo;

	@Override
	public ExpenseEntity createExpense(ExpenseEntity expense) {
		expense.setDate(LocalDateTime.now());
		return expenseRepo.save(expense);
	}

	@Override
	public ExpenseEntity getExpenseById(Integer expenseId) {
		return expenseRepo.findById(expenseId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Expense not found with giver Id : " + expenseId
						));
	}

	@Override
	public List<ExpenseEntity> getAllExpenses() {
		return expenseRepo.findAll();
	}

	@Override
	public ExpenseEntity updateExpense(ExpenseEntity expense) {
		// TODO Auto-generated method stub
		return expenseRepo.save(expense);
	}

	@Override
	public ExpenseEntity deleteExpense(Integer expenseId) {
		ExpenseEntity expense = expenseRepo.findById(expenseId).orElseThrow(
				() -> new ResourceNotFoundException(
				"Expense not found with giver Id : " + expenseId
				));
		
		expenseRepo.delete(expense);
		return expense;
	}

	@Override
	public List<ExpenseEntity> getAllExpensesByUserId(Integer userId) {
		List<ExpenseEntity> expenses = expenseRepo.findAllByUserId(userId);
		return expenses;
	}

	@Override
	public List<ExpenseEntity> getExpensesByUserId(Integer userId) {
		List<ExpenseEntity> expenses = expenseRepo.findAllByUserId(userId);
		return expenses;
	}

	@Override
	public List<ExpenseEntity> deleteAllExpensesByUserId(Integer userId) {
		List<ExpenseEntity> expenses = expenseRepo.deleteAllByUserId(userId);
		return expenses;
	}

	@Override
	public double getTotalExpenseOfUser(Integer userId) {
		System.out.println("Start");
		Map<String, Object> expense = expenseRepo.getSumOfexpenseByUserId(userId);
		
		double totalExpense = 0.0;
		
		if(null != expense.get("amount")) {
			return totalExpense = ( Double.valueOf(String.valueOf(expense.get("amount"))));
		}else {
			return totalExpense;
		}
	}
	
	
}
