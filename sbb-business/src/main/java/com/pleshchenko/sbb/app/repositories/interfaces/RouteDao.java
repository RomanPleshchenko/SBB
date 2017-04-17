package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.route.Route;
import com.pleshchenko.sbb.app.entity.route.Station;

/**
 * Created by РОМАН on 13.04.2017.
 */
public interface RouteDao {

    Route findByStation(Station departureStation,Station destinationStation, boolean createNew);
}
