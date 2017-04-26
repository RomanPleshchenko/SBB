package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.ticket.SiteCarClass;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.SiteCarClassDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Repository("siteCarClassDaoImpl")
public class SiteCarClassDaoImpl extends AbstractDao<Integer,SiteCarClass> implements SiteCarClassDao {
    @Override
    public List<SiteCarClass> findAll() {
        List<SiteCarClass> siteCarClasses = getEntityManager()
                .createQuery("SELECT s FROM SiteCarClass s")
                .getResultList();
        return siteCarClasses;

    }
}
