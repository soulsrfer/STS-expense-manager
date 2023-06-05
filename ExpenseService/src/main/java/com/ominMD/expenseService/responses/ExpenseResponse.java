package com.ominMD.expenseService.responses;

import java.util.List;



import com.ominMD.expenseService.entities.ExpenseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseResponse {
	private double totalIncome;
	private List<ExpenseEntity> incomeList;
}
