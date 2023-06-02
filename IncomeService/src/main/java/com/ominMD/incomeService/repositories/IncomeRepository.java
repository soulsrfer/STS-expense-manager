package com.ominMD.incomeService.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ominMD.incomeService.entities.IncomeEntity;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer>{

	List<IncomeEntity>  findByUserId(int userId);

	List<IncomeEntity> findAllByUserId(int userId);

	List<IncomeEntity> deleteAllByUserId(Integer userId);
	
	@Query(value= "select sum(amount) as amount from incomes where user_id = :userId",nativeQuery = true)
	Map<String, Object> getTotalAmountOfUser(Integer userId);
}
