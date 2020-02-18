package com.applicationcontroller.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.applicationcontroller.bean.EmployeeRequest;
import com.applicationcontroller.bean.EmployeeResponse;
import com.applicationcontroller.exceptions.UserExceptions;

@Controller
public class EmployeeControllerClass {
	Logger logger = Logger.getLogger(EmployeeControllerClass.class.getName());

	@GetMapping("/index")
	public String showFor(Model model) {
		logger.info("successfully reached index method");
		return "index";
	}

	@GetMapping("/empform")
	public String showForm(Model model) {
		logger.info("successfully reached empform method");
		return "empform";
	}

	@PostMapping(path = "/save")
	public String save(Model model, @ModelAttribute("emp") EmployeeRequest employeerequest) {
		try {
			EmployeeResponse response = JsonUtils.postServiceRequest(employeerequest, EmployeeResponse.class,
					Propertie.EMPLOYEE_URL, "/submit");
			if (response != null) {
				logger.info("successfully reached save method");
				return "redirect:/viewemp";
			} else {

				throw new UserExceptions(Propertie.EMP_SAVE);
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			logger.info("failed to save the data");
			return "empform";
		}
	}
	@PostMapping(path="/test")
	public String test(Model model, @ModelAttribute("emp") EmployeeRequest employeerequest) {
		try {
			EmployeeRequest emv= new EmployeeRequest();
			emv.setData("filed method dskjao");
			EmployeeResponse response = JsonUtils.postServiceRequest(employeerequest, EmployeeResponse.class,
					Propertie.EMPLOYEE_URL, "/test");
			return null;
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			logger.info("failed to save the data");
			return "empform";
		}
	}
	/*
	 * It shows the employee form details we can enter the name salary and
	 * designation
	 */

	@GetMapping(value = "/viewemp")
	public ModelAndView viewEmp(Map<String, Object> m) {
		EmployeeRequest employeerequest = new EmployeeRequest();
		try {
			EmployeeResponse response = JsonUtils.postServiceRequest(employeerequest, EmployeeResponse.class,
					Propertie.EMPLOYEE_URL, "/viewemp");
			List<EmployeeRequest> reqList = response.getEmployeeList();
			m.put("reqList", reqList);
			// m.put("request", new EmployeeRequest());
			if (!(reqList.isEmpty())) {
				return new ModelAndView("viewemp");
			} else {
				throw new UserExceptions("unable to fetch the data the from data base");
			}
		} catch (Exception e) {

			logger.info("failed to fetch the data base");
			m.put("error", e.getMessage());
			return new ModelAndView("index");
		}

	}

	@GetMapping(value = "/viewemp/{pageid}")
	public String viewemps(@PathVariable int pageid, Model m) {
		/*
		 * List<Emp> list=employeeService.getEmployee();
		 * m.addAttribute("list",list); return "viewemp";
		 */
		// int total1=0;
		int total = 5;
		if (pageid == 1) {
		} else {
			pageid = (pageid - 1) * total + 1;

		}
		
		// List<EmployeeRequest> list=employeeService.getEmployeesByPage(pageid,total);
		// m.addAttribute("list", list);
		return "viewemp";
	}

	@GetMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Map<String, Object> m,
			@ModelAttribute("emp") EmployeeRequest employeerequest) {
		try {
			EmployeeRequest response = JsonUtils.postServiceRequest(employeerequest, EmployeeRequest.class,
					Propertie.EMPLOYEE_URL, "/editemp");
			m.put("emp", response);
			if (response != null) {
				logger.info("succesfully reached edit value");
				return "empeditform";
			} else {
				throw new UserExceptions("unable to fetch the employee details ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("failed to fetch the value from the data base");
			m.put("error", e.getMessage());
			return "viewemp";
		}
	}

	@PostMapping(value = "/editsave")
	public String editSave(Model model, @ModelAttribute("emp") EmployeeRequest employeerequest) {
		try {
			EmployeeRequest response = JsonUtils.postServiceRequest(employeerequest, EmployeeRequest.class,
					Propertie.EMPLOYEE_URL, "/update");
			if (response != null) {
				logger.info("successfully edited the value");
				return "redirect:/viewemp";
			} else {
				throw new UserExceptions("unable to save the employee details");
			}
		} catch (Exception e) {
			logger.info("failed to load the values");
			model.addAttribute("error", e.getMessage());
			return "empeditform";
		}
	}

	@GetMapping(value = "/deleteemp/{id}")
	public String delete(Model model, @PathVariable int id, @ModelAttribute("emp") EmployeeRequest employeerequest) {
		try {
			EmployeeResponse response = JsonUtils.postServiceRequest(employeerequest, EmployeeResponse.class,
					Propertie.EMPLOYEE_URL, "/delete");
			if (response != null) {
				logger.info("successfully deleted the value in the data base");
				return "redirect:/viewemp";
			} else {
				throw new UserExceptions("unable to delete the employee details");
			}
		} catch (Exception e) {
			logger.info("failed to deleted the value in the data base");
			model.addAttribute("error", e.getMessage());
			return "redirect:/viewemp";
		}
	}

}
