package com.restcontroller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.restcontroller.beans.AdminUser;
import com.restcontroller.exceptions.UserExceptions;
import com.restcontroller.repository.AdminUserRepository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	AdminUserRepository userep;

	@PersistenceContext
	EntityManager entityManager;

	public AdminUser save(AdminUser emp) {
		AdminUser AdminUserVar = new AdminUser();
		try {
			AdminUserVar = userep.save(emp);
			if (!(AdminUserVar != null)) {
				throw new UserExceptions("unable to perform the repository");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AdminUserVar;

	}

	public List<AdminUser> findAll() {
		return userep.findAll();
	}

	public List<AdminUser> fetchUserDetailsByEmailAndPassword(AdminUser userentity) {
		// TODO Auto-generated method stub
		String eMail = userentity.getEmail();
		String Password = userentity.getPassword();
		return userep.findByEmailAndPassword(eMail, Password);
	}

	public List<AdminUser> fetchUserDetailsByUserName(AdminUser userentity) {
		String name = userentity.getEmail();
		return userep.findByEmail(name);
	}
	
	public long count() {
		return userep.count();
	}
	
	/*public List<AdminUser> fetchTheListByRange(int starting,int ending){
		return userep.findIdBetween(starting, ending);
		
	}*/
}
