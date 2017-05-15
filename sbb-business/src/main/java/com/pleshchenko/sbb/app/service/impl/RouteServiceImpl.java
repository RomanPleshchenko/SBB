package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.schedule.Route;
import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.repositories.interfaces.RouteDao;
import com.pleshchenko.sbb.app.service.interfaces.RouteService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("routeService")
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDao dao;

    @Override
    public List<Route> findAll() {
        List<Route> routes = dao.findAll();
        return routes;
    }

    @Override
    public String getRoutesJSON() {
        List<Route> routes = dao.findAll();

        JSONArray routeArray = new JSONArray();

        for (Route route:routes) {

            JSONObject ticketJSON = new JSONObject();
            ticketJSON.put("routeId",route.getId());
            ticketJSON.put("routeNumber",route.getNumber());
            ticketJSON.put("routeName",route.getName());
            routeArray.put(ticketJSON);
        }

        return routeArray.toString();

    }

    @Override
    public String getRoutesJSONByRouteId(int routeId) {

        Route route = dao.findById(routeId);

        Set<RouteComposition> routeCompositions = route.getRouteCompositions();

        JSONArray routeArray = new JSONArray();

        for (RouteComposition rc:routeCompositions) {

            JSONObject ticketJSON = new JSONObject();
            ticketJSON.put("segmentId",rc.getSegment().getId());
            ticketJSON.put("segmentName",rc.getSegment());
            ticketJSON.put("departureTime",rc.getDepartureTime());
            ticketJSON.put("destinationTime",rc.getDestinationTime());

            ticketJSON.put("departureStationId",rc.getSegment().getDepartureStation().getId());
            ticketJSON.put("departureStationName",rc.getSegment().getDepartureStation().getName());
            ticketJSON.put("destinationStationId",rc.getSegment().getDestinationStation().getId());
            ticketJSON.put("destinationStationName",rc.getSegment().getDestinationStation().getName());

            routeArray.put(ticketJSON);
        }

        return routeArray.toString();
    }
}
