package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
public interface RouteCompositionDao {

    List<RouteComposition> findAll();

    void deleteRouteComposition(RouteComposition routeComposition);

}
