package com.ominMD.incomeService.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ominMD.incomeService.entities.IncomeEntity;
import com.ominMD.incomeService.excaptions.ResourceNotFoundExcaption;
import com.ominMD.incomeService.repositories.IncomeRepository;
import com.ominMD.incomeService.responses.IncomeResponse;
import com.ominMD.incomeService.services.IncomeServices;

@Service
public class IncomeServicesImpl implements IncomeServices {
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@Override
	public IncomeEntity createIncome(IncomeEntity incomeEntity) {
		incomeEntity.setDate(LocalDateTime.now());
		IncomeEntity income=incomeRepository.save(incomeEntity);
		return income;
	}
	
	@Override
	public List<IncomeEntity> getAllIncome() {
		List<IncomeEntity> incomes=incomeRepository.findAll();
		return incomes;
	}
	
	@Override
	public IncomeEntity getIncomeByid(Integer id) {
		IncomeEntity income=incomeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcaption("income is not found for this id :"+id));
		return income;
	}
	
	@Override
	public List<IncomeEntity> getAllIncomeByUserId(int userId) {
		List<IncomeEntity> incomes= incomeRepository.findAllByUserId(userId);
		return incomes;
	}
	
	@Override
	public IncomeEntity deleteIncomeById(Integer id) {
		IncomeEntity income=incomeRepository.findById(id).get();
		incomeRepository.deleteById(id);
		return income;
	}
	
	@Override
	public IncomeEntity updateIncome(IncomeEntity incomeEntity) {
		IncomeEntity income=incomeRepository.save(incomeEntity);
		return income;
	}

	@Override
	public List<IncomeEntity> deleteAllIncomeByUser(Integer userId) {
		List<IncomeEntity> incomes = incomeRepository.deleteAllByUserId(userId);
		return null;
	}
	
	public double getTotalIncomeOfUser(@PathVariable("userId") Integer userId) {
		
		
		Map<String, Object> income = incomeRepository.getTotalIncomeOfUser(userId);
		
		double totalIncome = 0.0;
		
		if(null != income) {
			return totalIncome = ( Double.valueOf(String.valueOf(income.get("amount"))));
		}else {
			return totalIncome;
		}
	
	}

}
