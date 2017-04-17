package com.pleshchenko.sbb.model.repositories.impl;

import com.pleshchenko.sbb.model.entity.authorization.User;
import com.pleshchenko.sbb.model.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.model.repositories.interfaces.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findByName(String name) {

		Query query = getEntityManager()
				.createQuery("SELECT u FROM User u " +
						"WHERE u.name = :name ");
		query.setParameter("name",name);

		List<User> users = query.getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<User> findAll() {
		List<User> users = getEntityManager()
				.createQuery("SELECT u FROM User u")
				.getResultList();
		return users;
	}
}
