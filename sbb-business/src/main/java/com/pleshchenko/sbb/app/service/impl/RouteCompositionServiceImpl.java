package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.repositories.interfaces.RouteCompositionDao;
import com.pleshchenko.sbb.app.service.interfaces.RouteCompositionService;
import com.pleshchenko.sbb.app.service.interfaces.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("routeCompositionService")
@Transactional
public class RouteCompositionServiceImpl implements RouteCompositionService {

    @Autowired
    RouteCompositionDao dao;

    @Override
    public List<RouteComposition> findAll() {
        List<RouteComposition> routeCompositions = dao.findAll();
        return routeCompositions;
    }
}
