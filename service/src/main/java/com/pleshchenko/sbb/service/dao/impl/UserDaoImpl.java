package com.pleshchenko.sbb.service.dao.impl;

import com.pleshchenko.sbb.model.entity.authorization.User;
import com.pleshchenko.sbb.service.dao.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.dao.interfaces.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		User user = getByKey(id);
		if(user!=null){
			initializeCollection(user.getUserRoles());
		}
		return user;
	}

	public User findByName(String name) {
		try{
			User user = (User) getEntityManager()
					.createQuery("SELECT u FROM User u WHERE u.name LIKE :name")
					.setParameter("name", name)
					.getSingleResult();
			
			if(user!=null){
				initializeCollection(user.getUserRoles());
			}
			return user; 
		}catch(NoResultException ex){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> users = getEntityManager()
				.createQuery("SELECT u FROM User u ORDER BY u.name ASC")
				.getResultList();
		return users;
	}

	public void save(User user) {
		persist(user);
	}

	public void deleteByName(String name) {
		User user = (User) getEntityManager()
				.createQuery("SELECT u FROM User u WHERE u.name LIKE :name")
				.setParameter("name", name)
				.getSingleResult();
		delete(user);
	}
	
	//An alternative to Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
	    if(collection == null) {
	        return;
	    }
	    collection.iterator().hasNext();
	}

}
