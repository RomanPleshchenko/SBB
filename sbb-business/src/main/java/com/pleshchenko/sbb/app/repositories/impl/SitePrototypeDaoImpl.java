package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.ticket.SitePrototype;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.SitePrototypeDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Repository("sitePrototypeDao")
public class SitePrototypeDaoImpl extends AbstractDao<Integer,SitePrototype> implements SitePrototypeDao {
    @Override
    public List<SitePrototype> findAll() {
        List<SitePrototype> sitePrototypes = getEntityManager()
                .createQuery("SELECT s FROM SitePrototype s")
                .getResultList();
        return sitePrototypes;
    }
}
