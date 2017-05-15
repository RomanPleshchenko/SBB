package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Route;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("routeService")
@Transactional
public interface RouteService {

    /**
     *
     * @return a list of all route
     */
    List<Route> findAll();

    /**
     *
     * @return a JSON array of all route
     */
    String getRoutesJSON();

    String getRoutesJSONByRouteId(int routeId);
}
