package com.restcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restcontroller.beans.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {

	public List<AdminUser> findByEmailAndPassword(String email, String Password);

	public List<AdminUser> findByEmail(String email);
	
	public long count();
	
	/*public List<AdminUser> findIdBetween(int starting,int ending);
*/
}
