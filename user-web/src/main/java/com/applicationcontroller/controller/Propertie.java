package com.applicationcontroller.controller;

public class Propertie {

	private Propertie() {

	}

	public final static String NAME = "Name cannot be null";
	public final static String USER_NAME = "cannot be user_name as null";
	public final static String PSWD_EMPTY = "password cannot be null";
	public final static String SALARY = "salary should be greater than 1";
	public final static String DESIGNATION = "designation cannot be null";
	public final static String NOT_EXITS = "username and password had not matched";
	public final static String EXISTED = "username already exits";
	public final static String NO_USER = "username no exits";
	public final static String EMPLOYEE_URL = "http://localhost:8080/employeeForm/empRestController";
	public final static String USER_URL = "http://localhost:8080/employeeForm/userRestController";
	public final static String USER_LOGIN = "could match the data";
	public final static String EMP_SAVE = "unable to save the data";
}
