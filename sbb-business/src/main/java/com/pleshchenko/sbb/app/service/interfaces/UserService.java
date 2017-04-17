package com.pleshchenko.sbb.app.service.interfaces;



import com.pleshchenko.sbb.app.entity.authorization.User;

import java.util.List;


public interface UserService {

	User findByUserName(String name);

	List<User> findAll();

}