package com.pleshchenko.sbb.service.impl;


import com.pleshchenko.sbb.repositories.interfaces.UserDao;
import com.pleshchenko.sbb.service.interfaces.UserService;
import com.pleshchenko.sbb.model.entity.authorization.User;
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
		User user = dao.findByUserName(name);
		return user;
	}
}
