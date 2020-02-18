package com.restcontroller.controller;

import java.util.List;

import com.restcontroller.beans.AdminUser;
import com.restcontroller.beans.UserRequest;
import com.restcontroller.beans.UserResponse;

public interface UserService {
	public UserResponse save(UserRequest userentity);

	public UserResponse findAll();

	public UserResponse fetchUserDetailsByEmailAndPassword(UserRequest userrequest);

	public UserResponse fetchUserDetailsByUserName(UserRequest userrequest);
	
	/*public List<AdminUser> getEmployeesByPage(int pageid, int total);
*/
}
