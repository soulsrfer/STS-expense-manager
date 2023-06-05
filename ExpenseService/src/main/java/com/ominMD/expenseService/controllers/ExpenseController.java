package com.ominMD.expenseService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ominMD.expenseService.entities.ExpenseEntity;
import com.ominMD.expenseService.repositories.ExpenseRepository;
import com.ominMD.expenseService.responses.ExpenseResponse;
import com.ominMD.expenseService.services.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	
	@PostMapping
	public ResponseEntity<ExpenseEntity> createExpense(@RequestBody ExpenseEntity expense) {
//		System.out.println();
		ExpenseEntity expense1 = expenseService.createExpense(expense);
		
		return ResponseEntity.status(HttpStatus.OK).body(expense1);
	}
	
	@GetMapping("/{expenseId}")
	public ResponseEntity<ExpenseEntity> readExpense(@PathVariable Integer expenseId) {
		ExpenseEntity expense = expenseService.getExpenseById(expenseId);
		
		return ResponseEntity.status(HttpStatus.OK).body(expense);
	}
	
	@GetMapping
	public ResponseEntity<List<ExpenseEntity>> readAllExpenses() {
		List<ExpenseEntity> expenses = expenseService.getAllExpenses();
		
		return ResponseEntity.status(HttpStatus.OK).body(expenses);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ExpenseEntity>> readAllExpensesByUserId(@PathVariable("userId") Integer userId) {
		List<ExpenseEntity> expenses = expenseService.getAllExpensesByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(expenses);
	}
	
	@PutMapping
	public ResponseEntity<ExpenseEntity> updateExpense(@RequestBody ExpenseEntity expense) {
		ExpenseEntity updatedExpense = expenseService.updateExpense(expense);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedExpense);
	}
	
	@DeleteMapping("/{expenseId}")
	public ResponseEntity<ExpenseEntity> deleteExpense(@PathVariable Integer expenseId) {
		ExpenseEntity expense = expenseService.deleteExpense(expenseId);
		
		return ResponseEntity.status(HttpStatus.OK).body(expense);
	}
	
	@GetMapping("/totalExpense/{userId}")
	public ResponseEntity<ExpenseResponse> getTotalExpense(@PathVariable("userId") Integer userId) {
		ExpenseResponse response = ExpenseResponse.builder()
				.totalIncome(expenseService.getTotalExpenseOfUser(userId))
				.incomeList(expenseService.getAllExpensesByUserId(userId))
				.build();
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
				
		
	} 
	
	
	
	
	
}
