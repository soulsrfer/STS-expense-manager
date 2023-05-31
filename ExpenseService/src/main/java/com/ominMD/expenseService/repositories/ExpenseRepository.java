package com.ominMD.expenseService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ominMD.expenseService.entities.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> {

	List<ExpenseEntity> findAllByUserId(Integer userId);


}
