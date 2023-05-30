package com.ominMD.incomeService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ominMD.incomeService.entities.IncomeEntity;
import com.ominMD.incomeService.excaptions.ResourceNotFoundExcaption;
import com.ominMD.incomeService.repositories.IncomeRepository;
import com.ominMD.incomeService.services.IncomeServices;

@Service
public class IncomeServicesImpl implements IncomeServices {
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@Override
	public IncomeEntity createIncome(IncomeEntity incomeEntity) {
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
		List<IncomeEntity> incomes= incomeRepository.findByUserId(userId);
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

}
