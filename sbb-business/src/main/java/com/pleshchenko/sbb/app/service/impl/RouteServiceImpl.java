package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.schedule.Route;
import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.entity.schedule.Segment;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.repositories.interfaces.RouteDao;
import com.pleshchenko.sbb.app.service.interfaces.RouteCompositionService;
import com.pleshchenko.sbb.app.service.interfaces.RouteService;
import com.pleshchenko.sbb.app.service.interfaces.SegmentService;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
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

    @Autowired
    StationService stationService;

    @Autowired
    SegmentService segmentService;

    @Autowired
    RouteCompositionService routeCompositionService;

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

    @Override
    public void updateRouteFromJSON(String routeJSON) {

        JSONObject jsonObject = new JSONObject(routeJSON);
        int routeId = (int)jsonObject.get("routeId");
        JSONArray jsonArray = (JSONArray)jsonObject.get("arrayJSON");

        Route route = dao.findById(routeId);


        for (RouteComposition rc:route.getRouteCompositions()) {
            routeCompositionService.deleteRouteComposition(rc);
        }
        route.getRouteCompositions().clear();

        for (Object obj:jsonArray) {

            JSONObject jobj = (JSONObject)obj;

            int st1 = (Integer)jobj.get("st1");
            int st2 = (Integer)jobj.get("st2");
            Integer t1 = (Integer)jobj.get("t1");
            Integer t2 = (Integer)jobj.get("t2");

            //Ищем или создаем сегмент
            Station station1 = stationService.findById(st1);
            Station station2 = stationService.findById(st2);
            Segment segment = segmentService.findByStation(station1,station2,true);

            //заполняем routeComposition
            RouteComposition routeComposition = new RouteComposition();
            routeComposition.setSegment(segment);

            routeComposition.setDepartureTime(t1);
            routeComposition.setDestinationTime(t2);

            routeComposition.setRoute(route);
            route.getRouteCompositions().add(routeComposition);
        }

        //пытаемся сохранить в бд
        dao.saveRoute(route);

    }
}
