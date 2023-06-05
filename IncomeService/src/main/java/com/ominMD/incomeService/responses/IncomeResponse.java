package com.ominMD.incomeService.responses;

import java.util.List;

import com.ominMD.incomeService.entities.IncomeEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeResponse {
	
	private double totalIncome;
	private List<IncomeEntity> incomeList;
}
