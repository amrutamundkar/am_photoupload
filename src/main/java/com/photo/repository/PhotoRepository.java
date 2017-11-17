package com.photo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photo.model.Employee;

public interface PhotoRepository extends JpaRepository<Employee, Integer> {
	
	

}
