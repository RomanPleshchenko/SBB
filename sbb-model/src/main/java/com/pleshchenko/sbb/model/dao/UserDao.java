package com.pleshchenko.sbb.model.dao;



import com.pleshchenko.sbb.model.model.User;

import java.util.List;


public interface UserDao {

	User findById(int id);
	
	User findByName(String name);
	
	void save(User user);
	
	void deleteByName(String name);
	
	List<User> findAllUsers();

}

