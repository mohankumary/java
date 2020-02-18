package com.applicationcontroller.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.applicationcontroller.bean.UserRequest;
import com.applicationcontroller.bean.UserResponse;
import com.applicationcontroller.exceptions.UserExceptions;

@Controller
public class UserControllerClass {
	Logger logger = Logger.getLogger((UserControllerClass.class.getName()));

	@GetMapping("/Login")
	public String login(Model model) {
		// m.addAttribute("error", "could match the data");

		logger.info("successfully reached login in page");
		return "Login";
	}

	@PostMapping(value = "/submite")
	public String signup(Model model, @ModelAttribute("emp") UserRequest userrequest) {
		/* List<UserEntity> tochekuser=userinterface.CheckUserName(userrequest); */

		UserResponse tochekuser = JsonUtils.postServiceRequest(userrequest, UserResponse.class, Propertie.USER_URL,
				"/username");
		UserResponse toCheckEmailAndPassword = JsonUtils.postServiceRequest(userrequest, UserResponse.class,
				Propertie.USER_URL, "/email");
		try {
			if (userrequest.getEmail().equals("")) {
				model.addAttribute("eror", Propertie.USER_NAME);
				return "redirect:/Login";
			} else if (userrequest.getPassword().equals("")) {
				model.addAttribute("eror", Propertie.PSWD_EMPTY);
				return "redirect:/Login";
			} else if (tochekuser==null) {
				return "redirect:/Login";
			} else if (toCheckEmailAndPassword.getStatus().equals("success")) {
				logger.info("successfully reached logged in");
				return "redirect:/index";
			} else {

				logger.info("unable to match the data in the database");
				throw new UserExceptions("user not found");
			}
		} catch (UserExceptions e) {
			model.addAttribute("eror", e.getMessage());
			model.addAttribute("error", Propertie.USER_LOGIN);
			return "/Login";
		}
	}

	@GetMapping("/SignIn")
	public String signup(Model m) {
		logger.info("successfully reached Sign in page");
		return "Signup";
	}

	@PostMapping(value = "/submi")
	public String submit(Model model, @ModelAttribute("emp") UserRequest userrequest) {
		UserResponse tochekuser = JsonUtils.postServiceRequest(userrequest, UserResponse.class, Propertie.USER_URL,
				"/username");
		try {
			if (userrequest.getFirst_name().equals("")) {
				model.addAttribute("eror", Propertie.NO_USER);
				return "redirect:/SignIn";
			} else if (userrequest.getEmail().equals("")) {
				model.addAttribute("eror", Propertie.NOT_EXITS);
				return "redirect:/SignIn";
			} else if (userrequest.getPassword().equals("")) {
				return "redirect:/SignIn";
			} else if (tochekuser.getStatus().equals("failure")) {
				return "redirect:/SignIn";
			} else if (!(userrequest.getFirst_name().equals("") && userrequest.getEmail().equals("")
					&& userrequest.getPassword().equals(""))) {
				JsonUtils.postServiceRequest(userrequest, UserResponse.class, Propertie.USER_URL, "/submit");
				logger.info("succesfully saved the data for signup");
				return "redirect:/Login";
			} else {
				throw new UserExceptions("unable to create an account");
			}
		} catch (UserExceptions e) {
			logger.info("unable to save the data");
			model.addAttribute("eror", e.getMessage());
			return "redirect:/Login";
		}
	}
}
