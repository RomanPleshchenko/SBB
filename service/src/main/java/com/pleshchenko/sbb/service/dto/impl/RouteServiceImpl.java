package com.pleshchenko.sbb.service.dto.impl;

import com.pleshchenko.sbb.model.entity.route.Route;
import com.pleshchenko.sbb.model.entity.route.Station;
import com.pleshchenko.sbb.service.dto.interfaces.RouteService;
import com.pleshchenko.sbb.service.repositories.interfaces.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by РОМАН on 13.04.2017.
 */
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDao dao;
    @Override
    public Route findByStation(Station departureStation, Station destinationStation, boolean createNew) {
        Route route = dao.findByStation(departureStation,destinationStation,createNew);
        return route;
    }
}
