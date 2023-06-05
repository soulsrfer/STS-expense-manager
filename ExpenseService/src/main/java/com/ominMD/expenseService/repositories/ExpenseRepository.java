package com.ominMD.expenseService.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ominMD.expenseService.entities.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> {

	List<ExpenseEntity> findAllByUserId(Integer userId);

	List<ExpenseEntity> deleteAllByUserId(Integer userId);
	
	@Query(value= "select sum(amount) as amount from expenses where user_id = :userId",nativeQuery = true)
	Map<String, Object> getSumOfexpenseByUserId(Integer userId);


}
