package com.restcontroller.dao;

import java.util.List;

import com.restcontroller.beans.Emp;

public interface EmployeeDao {

	public List<Emp> findAll();

	public Emp save(Emp emp);

	public Emp update(Emp emp);

	public Emp getEmployeeById(int id);

	public void delete(int id);
	
	//public long count();
	
	/*public List<Emp> fetchTheListByRange(int starting,int ending);*/
}
