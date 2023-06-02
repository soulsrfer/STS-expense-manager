package com.ominMD.incomeService.controllers;

import java.util.List;
import java.util.Map;

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

import com.ominMD.incomeService.entities.IncomeEntity;
import com.ominMD.incomeService.repositories.IncomeRepository;
import com.ominMD.incomeService.responses.IncomeResponse;
import com.ominMD.incomeService.services.IncomeServices;

@RestController
@RequestMapping("incomes")
public class IncomeController {

	@Autowired
	IncomeServices incomeServices;
	
	@Autowired
	IncomeRepository incomeRepo;
	
	@PostMapping("")
	public ResponseEntity<IncomeEntity> addIncome(@RequestBody IncomeEntity incomeEntity) {
		IncomeEntity income=incomeServices.createIncome(incomeEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(income);
	}
	
	@GetMapping
	public ResponseEntity<List<IncomeEntity>> getAllIncome(){
		List<IncomeEntity> incomes=incomeServices.getAllIncome();
		return ResponseEntity.status(HttpStatus.OK).body(incomes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<IncomeEntity> getIncomeById(@PathVariable("id") Integer id){
		IncomeEntity income=incomeServices.getIncomeByid(id);
		return ResponseEntity.status(HttpStatus.OK).body(income);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<IncomeEntity>> getIncomeByUserId(@PathVariable("userId") int userId){
	  List<IncomeEntity> income=incomeServices.getAllIncomeByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(income);
				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<IncomeEntity> deleteIncomeById(@PathVariable("id") Integer id){
		IncomeEntity income=incomeServices.deleteIncomeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(income);
	}
	
	@PutMapping
	public ResponseEntity<IncomeEntity> updateIncome(@RequestBody IncomeEntity incomeEntity){
		IncomeEntity income=incomeServices.updateIncome(incomeEntity);
		return ResponseEntity.status(HttpStatus.OK).body(income);
	}
	
	@GetMapping("/totalAmount/{userId}")
	public ResponseEntity<IncomeResponse> getTotalIncome(@PathVariable("userId") Integer userId) {
		System.out.println(userId);
		List<IncomeEntity> incomes = incomeServices.getAllIncomeByUserId(userId);
		
		IncomeResponse resp = new IncomeResponse();
		Map<String, Object> income = incomeRepo.getTotalAmountOfUser(userId);
		resp.setTotalAmount( Double.valueOf(String.valueOf(income.get("amount"))));
		resp.setIncomes(incomes);
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
}
