package com.restcontroller.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restcontroller.beans.UserRequest;
import com.restcontroller.beans.UserResponse;
import com.restcontroller.exceptions.UserExceptions;

@RestController
@Validated
@RequestMapping(value = "/userRestController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

	@Autowired
	UserService userservice;

	@GetMapping(value = "/useremp")
	public UserResponse viewUser() {
		UserResponse response = new UserResponse();
		try {
			response = userservice.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping(value = "/submit")
	public UserResponse signup(Model model, @RequestBody UserRequest userrequest) {

		UserResponse response = new UserResponse();
		/*
		 * if (userrequest.getUserName().equals("")) { response.setErrorCode("01");
		 * response.setError("name is required"); return response; } else if
		 * (userrequest.getEmail().equals("")) { response.setErrorCode("01");
		 * response.setError("name is required"); return response; } else if
		 * (userrequest.getPassword().equals("")) { response.setErrorCode("01");
		 * response.setError("name is required"); return response; }
		 */ try {
			response = userservice.save(userrequest);
			if (response.getStatus().equals("success")) {
				return response;
			} else {
				throw new UserExceptions("unable to save the request");
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return response;
		}
	}

	@PostMapping(value = "/username")
	public UserResponse fetchUserDetailsByUserName(@RequestBody UserRequest userrequest) {
		UserResponse response = new UserResponse();
		try {
			response = userservice.fetchUserDetailsByUserName(userrequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping(value = "/email")
	public UserResponse fetchUserDetailsByEmailAndPassword(@RequestBody UserRequest userrequest) {
		UserResponse response = new UserResponse();
		try {
			response = userservice.fetchUserDetailsByEmailAndPassword(userrequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	@PostMapping(value = "/test")
	private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("/home/ravva/Raghavendra/testing.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
