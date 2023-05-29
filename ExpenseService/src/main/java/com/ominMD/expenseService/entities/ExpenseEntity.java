package com.ominMD.expenseService.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "expenses")
public class ExpenseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double amount;
	private Date date;
	private Integer userId;
	
}