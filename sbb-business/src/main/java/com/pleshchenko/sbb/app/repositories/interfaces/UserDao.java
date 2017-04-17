package com.pleshchenko.sbb.app.repositories.interfaces;



import com.pleshchenko.sbb.app.entity.authorization.User;

import java.util.List;


public interface UserDao {

	User findByName(String name);

	List<User> findAll();

}

