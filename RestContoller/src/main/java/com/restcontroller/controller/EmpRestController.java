package com.restcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restcontroller.beans.EmployeeRequest;
import com.restcontroller.beans.EmployeeResponse;
import com.restcontroller.exceptions.UserExceptions;

@RestController
@Validated
@RequestMapping(value = "/empRestController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpRestController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/viewemp")
	public EmployeeResponse viewEmp(@RequestBody EmployeeRequest employeeReq, BindingResult binding) {
		EmployeeResponse response = new EmployeeResponse();
		try {
		
				response = employeeService.getEmployee();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping(value = "/submit")
	public EmployeeResponse signUp(Model model, @RequestBody EmployeeRequest employeeReq, BindingResult binding) {
		EmployeeResponse response = new EmployeeResponse();
		/*
		 * if(binding.hasErrors()) { List<ObjectError> ne=binding.getAllErrors();
		 * response.setError(ne.getDefaultMessage); }
		 * if(employeeReq.getFirst_name().equals("")) { response.setErrorCode("01");
		 * response.setError("name is required"); return response; } else if
		 * (employeeReq.getSalary()==0) { response.setErrorCode("02");
		 * response.setError("salary should be greater than 1"); return response; } else
		 * if(employeeReq.getDesignation().equals("")) { response.setErrorCode("03");
		 * response.setError("designation cannot be null"); return response; }
		 */
		try {
			response = employeeService.save(employeeReq);
			if (response.getStatus().equals("success")) {
				return response;
			} else {
				throw new UserExceptions("unable to save the employee details");
			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return response;
		}
	}

	/*
	 * @PostMapping(value="/editemp/{id}") public EmployeeRequest edit(int
	 * id,@RequestBody EmployeeRequest employeeReq){ EmployeeRequest response = new
	 * EmployeeRequest(); employeeReq.setId(id);
	 * response=employeeService.getEmployeeById(employeeReq); return response; }
	 */
	@PostMapping(value = "/editemp")
	public EmployeeRequest editEmpolyee(Model model, @RequestBody EmployeeRequest employeeReq) {
		EmployeeRequest response = new EmployeeRequest();
		try {
			response = employeeService.getEmployeeById(employeeReq);
			if (!(response.equals(null))) {
				return response;
			} else {
				throw new UserExceptions("unable to edit the employee details");
			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return response;
		}

	}

	@PostMapping(value = "/update")
	public EmployeeResponse update(@RequestBody EmployeeRequest employeeReq) {
		EmployeeResponse response = new EmployeeResponse();
		response = employeeService.update(employeeReq);
		return response;
	}

	@PostMapping(value = "/delete")
	public EmployeeResponse delete(@RequestBody EmployeeRequest employeeReq) {
		employeeService.getEmployeeByIdToDelete(employeeReq);
		return null;

	}
	
	  

}
