package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.route.Route;
import com.pleshchenko.sbb.app.entity.route.Station;
import com.pleshchenko.sbb.app.service.interfaces.RouteService;
import com.pleshchenko.sbb.app.repositories.interfaces.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by РОМАН on 13.04.2017.
 */
@Service("routeService")
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDao dao;
    @Override
    public Route findByStation(Station departureStation, Station destinationStation, boolean createNew) {
        Route route = dao.findByStation(departureStation,destinationStation,createNew);
        return route;
    }
}
