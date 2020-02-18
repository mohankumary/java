package com.restcontroller.dao;

import java.util.List;

import com.restcontroller.beans.AdminUser;

public interface UserDao {
	public AdminUser save(AdminUser emp);

	public List<AdminUser> findAll();

	public List<AdminUser> fetchUserDetailsByEmailAndPassword(AdminUser emp);

	public List<AdminUser> fetchUserDetailsByUserName(AdminUser userentity);

	public long count();
	
/*	public List<AdminUser> fetchTheListByRange(int starting,int ending);*/
}
