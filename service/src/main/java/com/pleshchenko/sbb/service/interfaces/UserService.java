package com.pleshchenko.sbb.service.interfaces;



import com.pleshchenko.sbb.model.model.entity.authorization.User;

import java.util.List;


public interface UserService {
	
	User findById(int id);
	
	User findByName(String sso);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByName(String name);

	List<User> findAllUsers(); 
	
	boolean isUserNameUnique(Integer id, String name);

}