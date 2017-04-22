package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.authorization.Role;
import com.pleshchenko.sbb.app.entity.authorization.User;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.UserDao;
import com.pleshchenko.sbb.app.service.interfaces.RoleService;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

//	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	RoleService roleService;

	public User findById(int id) {
		User user = getByKey(id);
		if(user!=null){
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	public User findBySSO(String sso) {

		Query query = getEntityManager()
				.createQuery("SELECT u FROM User u " +
						"WHERE u.ssoId = :ssoId ");
		query.setParameter("ssoId",sso);

		List<User> users = query.getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> users = getEntityManager()
				.createQuery("SELECT u FROM User u")
				.getResultList();
		return users;
	}

	public void save(User user) {

		if (user.getRoles().size()==0){
			Set<Role> set = new HashSet<Role>();
			set.add(roleService.findByType("USER"));
			user.setRoles(set);
		}
		persist(user);
	}

	public void deleteBySSO(String sso) {

		User user = findBySSO(sso);
		if (user!=null){
			delete(user);
		}

	}

}
