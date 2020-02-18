package com.restcontroller.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restcontroller.beans.AdminUser;
import com.restcontroller.beans.UserRequest;
import com.restcontroller.beans.UserResponse;
import com.restcontroller.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao UserDao;

	public UserResponse save(UserRequest userrequest) {
		AdminUser userentity = new AdminUser();
		UserResponse userRes = new UserResponse();
		try {
			BeanUtils.copyProperties(userrequest, userentity);
			AdminUser user = UserDao.save(userentity);
			if (user != null) {
				userRes.setStatus("success");
			} else {
				userRes.setErrorCode("045");
				userRes.setStatus("failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRes;
	}

	public UserResponse findAll() {
		UserResponse userRes = new UserResponse();
		try {

			List<AdminUser> list = UserDao.findAll();
			if (!list.isEmpty()) {
				List<UserRequest> userList = new ArrayList<>();
				for (AdminUser adminUser : list) {
					UserRequest userRequest = new UserRequest();
					BeanUtils.copyProperties(adminUser, userRequest);
					userList.add(userRequest);
				}
				userRes.setUserList(userList);
				userRes.setStatus("success");
				userRes.setErrorCode("00");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRes;
	}

	public UserResponse fetchUserDetailsByEmailAndPassword(UserRequest userrequest) {
		UserResponse userRes = new UserResponse();
		AdminUser userentity = new AdminUser();
		BeanUtils.copyProperties(userrequest, userentity);
		try {
			List<AdminUser> userentity1 = UserDao.fetchUserDetailsByEmailAndPassword(userentity);
			if (userentity1.size() > 0) {
				userRes.setStatus("success");
			} else {
				userRes.setError("046");
				userRes.setStatus("failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRes;
	}

	public UserResponse fetchUserDetailsByUserName(UserRequest userrequest) {
		UserResponse userRes = new UserResponse();
		AdminUser userentity = new AdminUser();
		userentity.setEmail(userrequest.getEmail());
		List<AdminUser> userentity2 = UserDao.fetchUserDetailsByUserName(userentity);
		try {
			if (userentity2.size() == 0) {
				userRes.setStatus("success");
			} else {
				userRes.setError("046");
				userRes.setStatus("failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRes;
	}
	/*public List<AdminUser> getEmployeesByPage(int pageid, int total) {
		return UserDao.fetchTheListByRange(pageid, total);
	}
*/
}
