package com.pleshchenko.sbb.service.interfaces;

import com.pleshchenko.sbb.model.entity.route.Route;
import com.pleshchenko.sbb.model.entity.route.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by РОМАН on 13.04.2017.
 */
@Service("routeService")
@Transactional
public interface RouteService {
    Route findByStation(Station departureStation, Station destinationStation, boolean createNew);
}
