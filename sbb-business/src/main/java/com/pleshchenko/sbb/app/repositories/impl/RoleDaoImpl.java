package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.authorization.Role;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.RoleDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository("userProfileDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao{

	public Role findById(int id) {
		return getByKey(id);
	}

	public Role findByType(String type) {

		Query query = getEntityManager()
				.createQuery("SELECT r FROM Role r " +
						"WHERE r.type = :type ");
		query.setParameter("type",type);

		List<Role> users = query.getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> findAll(){

		List<Role> roles = getEntityManager()
				.createQuery("SELECT r FROM Role r")
				.getResultList();
		return roles;
	}
	
}
