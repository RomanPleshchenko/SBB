package com.pleshchenko.sbb.app.repositories.interfaces;


import com.pleshchenko.sbb.app.entity.authorization.PersistentLogin;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistentLogin>
		implements PersistentTokenRepository {

//	static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
//		logger.info("Creating Token for user : {}", token.getUsername());
		System.out.println("createNewToken");
		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		persist(persistentLogin);

	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		System.out.println("PersistentRememberMeToken");
//		logger.info("Fetch Token if any for seriesId : {}", seriesId);

		try {
			PersistentLogin persistentLogin = (PersistentLogin)getEntityManager()
					.createQuery("SELECT p FROM PersistentLogin p WHERE p.series = :series").setParameter("series",seriesId)
					.getSingleResult();

			return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
					persistentLogin.getToken(), persistentLogin.getLast_used());
		}catch (Exception e){
			return null;
		}

	}

	@Override
	public void removeUserTokens(String username) {
		System.out.println("removeUserTokens");
////		logger.info("Removing Token if any for user : {}", username);
//		Criteria crit = createEntityCriteria();
//		crit.add(Restrictions.eq("username", username));
//		PersistentLogin persistentLogin = (PersistentLogin) crit.uniqueResult();
//		if (persistentLogin != null) {
////			logger.info("rememberMe was selected");
//			delete(persistentLogin);
//		}

	}

	@Override
	public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
//		logger.info("Updating Token for seriesId : {}", seriesId);
		System.out.println("updateToken");
		PersistentLogin persistentLogin = getByKey(seriesId);
		persistentLogin.setToken(tokenValue);
		persistentLogin.setLast_used(lastUsed);
		persist(persistentLogin);
	}

}
