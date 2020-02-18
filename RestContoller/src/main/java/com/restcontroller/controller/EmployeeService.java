package com.restcontroller.controller;

import com.restcontroller.beans.EmployeeRequest;
import com.restcontroller.beans.EmployeeResponse;

public interface EmployeeService {

	public EmployeeResponse getEmployee();

	public EmployeeResponse save(EmployeeRequest employeeReq);

	public EmployeeResponse update(EmployeeRequest employeeReq);

	public EmployeeRequest getEmployeeById(EmployeeRequest employeeReq);

	public EmployeeRequest getEmployeeByIdToDelete(EmployeeRequest employeeReq);
	
	//public long count();
	
	/*public List<Emp> getEmployeesByPage(int pageid, int total);
*/

}
