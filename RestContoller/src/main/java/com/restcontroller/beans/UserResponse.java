package com.restcontroller.beans;

import java.util.List;

public class UserResponse {
	private String error;

	private String status;

	private String errorCode;

	private List<UserRequest> UserList;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<UserRequest> getUserList() {
		return UserList;
	}

	public void setUserList(List<UserRequest> userList) {
		UserList = userList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
