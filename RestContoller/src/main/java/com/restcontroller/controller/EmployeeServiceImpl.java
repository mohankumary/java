package com.restcontroller.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restcontroller.beans.Emp;
import com.restcontroller.beans.EmployeeRequest;
import com.restcontroller.beans.EmployeeResponse;
import com.restcontroller.dao.EmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public EmployeeResponse getEmployee() {
		EmployeeResponse empRes = new EmployeeResponse();
		try {

			List<Emp> list = employeeDao.findAll();
			if (!list.isEmpty()) {
				List<EmployeeRequest> employeelList = new ArrayList<>();
				for (Emp emp : list) {
					EmployeeRequest employeeRequest = new EmployeeRequest();
					BeanUtils.copyProperties(emp, employeeRequest);
					employeelList.add(employeeRequest);
				}

				empRes.setEmployeeList(employeelList);
				empRes.setStatus("success");
				empRes.setErrorCode("00");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empRes;
	}

	public EmployeeResponse save(EmployeeRequest employeeReq) {
		Emp emp = new Emp();
		EmployeeResponse empRes = new EmployeeResponse();
		try {

			BeanUtils.copyProperties(employeeReq, emp);

			Emp emp2 = employeeDao.save(emp);
			if (emp2 != null) {
				empRes.setStatus("success");
				empRes.setErrorCode("00");
			} else {
				empRes.setStatus("failure");
				empRes.setErrorCode("000");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empRes;

	}

	public EmployeeResponse update(EmployeeRequest employeeReq) {
		Emp emp = new Emp();
		BeanUtils.copyProperties(employeeReq, emp);
		Emp emp2 = employeeDao.save(emp);
		EmployeeResponse empRes = new EmployeeResponse();
		if (emp2 != null) {
			empRes.setStatus("sucess");
		} else {
			empRes.setStatus("null");
		}
		return empRes;
	}

	public EmployeeRequest getEmployeeById(EmployeeRequest employeeReq) {
		EmployeeRequest employeeRequest = new EmployeeRequest();
		Emp emp = employeeDao.getEmployeeById(employeeReq.getId());
		BeanUtils.copyProperties(emp, employeeRequest);
		return employeeRequest;
	}

	public EmployeeRequest getEmployeeByIdToDelete(EmployeeRequest employeeReq) {
		EmployeeResponse empRes = new EmployeeResponse();
		/* int id =employeeReq.getId(); */
		employeeDao.delete(employeeReq.getId());
		empRes.setStatus("Sucess");
		return null;
	}
	
	/*public long count() {
		return employeeDao.count();
	}*/
	 /*private static void writeUsingFiles(String data) {
	        try {
	            Files.write(Paths.get("/home/ravva/Raghavendra/testing.txt"), data.getBytes());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }*/

	/*@Override
	public List<Emp> getEmployeesByPage(int pageid, int total) {
		return employeeDao.fetchTheListByRange(pageid, total);
		
	}*/
}
