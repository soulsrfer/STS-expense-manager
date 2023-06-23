package com.ominMD.userService.responses;

import java.util.List;


import com.ominMD.userService.dto.Expense;
import com.ominMD.userService.dto.Income;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
	
	private Integer id;

	private String firstName;

	private String lastName;

	private String contact;

	private String email;
	
	private String role;
	
	private double balance;

	List<Expense> expenses;

	List<Income> incomes;
	
	
}
