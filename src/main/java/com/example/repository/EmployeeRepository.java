package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	public List<EmployeeEntity> findByFirstname(String firstName);
	
	public EmployeeEntity findById(Integer id);
	
}
