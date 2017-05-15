package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.authorization.User;
import java.util.List;


public interface UserService {

	/**
	 *
	 * @param id of user
	 * @return user by id
	 */
	User findById(int id);

	/**
	 *
	 * @param sso
	 * @return user by sso
	 */
	User findBySSO(String sso);

	/**
	 * save user  in DB
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * update user in DB
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * dekete user from DB by sso
	 * @param sso
	 */
	void deleteUserBySSO(String sso);

	/**
	 *
	 * @return a list of all user
	 */
	List<User> findAllUsers();

	/**
	 *
	 * @param id
	 * @param sso
	 * @return
	 */
	boolean isUserSSOUnique(Integer id, String sso);

}