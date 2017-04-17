package com.pleshchenko.sbb.model.service.interfaces;



import com.pleshchenko.sbb.model.entity.authorization.User;

import java.util.List;


public interface UserService {

	User findByUserName(String name);

	List<User> findAll();

}