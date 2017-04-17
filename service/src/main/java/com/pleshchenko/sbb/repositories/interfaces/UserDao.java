package com.pleshchenko.sbb.repositories.interfaces;



import com.pleshchenko.sbb.model.entity.authorization.User;

import java.util.List;


public interface UserDao {

	User findByName(String name);

	List<User> findAll();

}

