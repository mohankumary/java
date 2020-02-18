package com.restcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restcontroller.beans.Emp;

public interface EmployeeRepository extends JpaRepository<Emp, Integer> {

	public Emp findById(int id);
	/*public List<Emp> findIdBetween(int starting,int ending);*/
}
