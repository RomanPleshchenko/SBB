package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Route;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
public interface RouteDao {

    List<Route> findAll();

    Route findById(int id);

    void saveRoute(Route route);

}
