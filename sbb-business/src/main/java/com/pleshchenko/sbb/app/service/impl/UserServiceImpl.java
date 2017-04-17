package com.pleshchenko.sbb.app.service.impl;


import com.pleshchenko.sbb.app.repositories.interfaces.UserDao;
import com.pleshchenko.sbb.app.service.interfaces.UserService;
import com.pleshchenko.sbb.app.entity.authorization.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;


	@Override
	public User findByUserName(String name) {
		User user = dao.findByName(name);
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = dao.findAll();
		return users;
	}
}
