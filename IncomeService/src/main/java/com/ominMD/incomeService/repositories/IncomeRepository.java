package com.ominMD.incomeService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ominMD.incomeService.entities.IncomeEntity;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer>{

	List<IncomeEntity>  findByUserId(int userId);

	List<IncomeEntity> findAllByUserId(int userId);
}
