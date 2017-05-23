package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.SiteCarClass;
import com.pleshchenko.sbb.app.repositories.interfaces.SiteCarClassDao;
import com.pleshchenko.sbb.app.service.interfaces.SiteCarClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("siteCarClassServiceImpl")
@Transactional
public class SiteCarClassServiceImpl implements SiteCarClassService {

    @Autowired
    private SiteCarClassDao dao;

    @Override
    public List<SiteCarClass> findAll() {
        List<SiteCarClass> siteCarClasses = dao.findAll();
        return siteCarClasses;

    }

    @Override
    public SiteCarClass findById(int id) {
        SiteCarClass siteCarClass =  dao.findById(id);
        return siteCarClass;
    }
}
