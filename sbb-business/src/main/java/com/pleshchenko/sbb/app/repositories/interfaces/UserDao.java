package com.pleshchenko.sbb.app.repositories.interfaces;



import com.pleshchenko.sbb.app.entity.authorization.User;

import java.util.List;


public interface UserDao {

	User findById(int id);

	User findBySSO(String sso);

	void save(User user);

	void deleteBySSO(String sso);

	List<User> findAllUsers();

}

