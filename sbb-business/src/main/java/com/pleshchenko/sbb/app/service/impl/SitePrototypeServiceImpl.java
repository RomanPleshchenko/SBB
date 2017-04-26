package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.SitePrototype;
import com.pleshchenko.sbb.app.repositories.interfaces.SitePrototypeDao;
import com.pleshchenko.sbb.app.service.interfaces.SitePrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("sitePrototypeService")
@Transactional
public class SitePrototypeServiceImpl implements SitePrototypeService {

    @Autowired
    SitePrototypeDao dao;

    @Override
    public List<SitePrototype> findAll() {
        List<SitePrototype> sitePrototypes = dao.findAll();
        return sitePrototypes;
    }
}
