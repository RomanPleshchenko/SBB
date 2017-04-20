package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.authorization.User;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.UserDao;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

//	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	public User findById(int id) {
		User user = getByKey(id);
		if(user!=null){
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	public User findBySSO(String sso) {
//		logger.info("SSO : {}", sso);
//		Criteria crit = createEntityCriteria();
//		crit.add(Restrictions.eq("ssoId", sso));
//		User user = (User)crit.uniqueResult();
//		if(user!=null){
//			Hibernate.initialize(user.getRoles());
//		}
//		return user;


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
//		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
//		List<User> users = (List<User>) criteria.list();
//
//		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
//		// Uncomment below lines for eagerly fetching of userProfiles if you want.
//		/*
//		for(User user : users){
//			Hibernate.initialize(user.getUserProfiles());
//		}*/
//		return users;

		List<User> users = getEntityManager()
				.createQuery("SELECT u FROM User u")
				.getResultList();
		return users;
	}

	public void save(User user) {
		persist(user);
	}

	public void deleteBySSO(String sso) {
//		Criteria crit = createEntityCriteria();
//		crit.add(Restrictions.eq("ssoId", sso));
//		User user = (User)crit.uniqueResult();
		User user = findBySSO(sso);
		if (user!=null){
			delete(user);
		}

	}

}
