package com.pleshchenko.sbb.service.dto.impl;


import com.pleshchenko.sbb.service.repositories.interfaces.UserDao;
import com.pleshchenko.sbb.service.dto.interfaces.UserService;
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
	public User findById(int id) {
		return dao.findById(id);
	}

	@Override
	public User findByName(String name) {
		User user = dao.findByName(name);
		return user;
	}

	@Override
	public void saveUser(User user) {
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	@Override
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setPassword(user.getPassword());
			entity.setName(user.getName());
//			entity.setUserRoles(user.getUserRoles());
		}
	}

	@Override
	public void deleteUserByName(String name) {
		dao.deleteByName(name);
	}

	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public boolean isUserNameUnique(Integer id, String name) {
		User user = findByName(name);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
