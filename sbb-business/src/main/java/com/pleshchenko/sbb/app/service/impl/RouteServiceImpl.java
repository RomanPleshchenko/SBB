package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.schedule.Route;
import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.entity.schedule.Segment;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.exception.IncorrectRouteCompositionException;
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
import java.util.TreeSet;

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

        TreeSet<RouteComposition> routeCompositionsTreeSet = new TreeSet<>(routeCompositions);

        JSONArray routeArray = new JSONArray();

        for (RouteComposition rc:routeCompositionsTreeSet) {

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

    //QQQQQQQQQQQQQQQQQqq не работает транзакция
    @Transactional
    @Override
    public void updateRouteFromJSON(String routeJSON) throws IncorrectRouteCompositionException {

        JSONObject jsonObject = new JSONObject(routeJSON);
        int routeId = (int)jsonObject.get("routeId");
        JSONArray jsonArray = (JSONArray)jsonObject.get("arrayJSON");

        Route route = dao.findById(routeId);

        TreeSet<RouteComposition> routeCompositions = new TreeSet<>();
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
            routeCompositions.add(routeComposition);
        }

        if(jsonArray.length()!=routeCompositions.size()){
            throw new IncorrectRouteCompositionException("There should not be two components with the same departure time");
        }

        cheakRouteCompositions(routeCompositions);

        //удалим старые элементы
        for (RouteComposition rc:route.getRouteCompositions()) {
            routeCompositionService.deleteRouteComposition(rc);
        }

        //очистим таблицу элементов для маршрута
        route.getRouteCompositions().clear();

        //заполним новыми элементами
        for (RouteComposition rc:routeCompositions) {
            route.getRouteCompositions().add(rc);
        }

        //пытаемся сохранить в бд
        dao.saveRoute(route);

    }

    private void cheakRouteCompositions(TreeSet<RouteComposition> routeCompositions) throws IncorrectRouteCompositionException {

        RouteComposition lastRC = null;

        HashSet<Station> depStations = new HashSet<>();
        HashSet<Station> desStations = new HashSet<>();
        HashSet<Station> usedStations = new HashSet<>();

        for (RouteComposition rc:routeCompositions) {
            if(rc.getDepartureTime()>=rc.getDestinationTime()){
                throw new IncorrectRouteCompositionException("The departure time and destination time should differ and the departure time should be more than the destination");
            }

            if(rc.getSegment().getDepartureStation()==rc.getSegment().getDestinationStation()){
                throw new IncorrectRouteCompositionException("The departure station and destination station should differ");
            }

            if(lastRC!=null){
                //станция отправления каждого следующего сегмента должна совпадать со станцией прибытия предыдущей
                if(rc.getSegment().getDepartureStation()!=lastRC.getSegment().getDestinationStation()){
                    throw new IncorrectRouteCompositionException("The departure station of previous route composition and destination station of next route composition must coincide");
                }

                if(rc.getDepartureTime() <= lastRC.getDestinationTime()){
                    throw new IncorrectRouteCompositionException("The destination time of next route composition should be more than the departure time of the previous route composition");
                }

                if(usedStations.contains(rc.getSegment().getDepartureStation())){
                    throw new IncorrectRouteCompositionException("Station:" + rc.getSegment().getDepartureStation().getName() + " - already used");
                }

                if(usedStations.contains(rc.getSegment().getDestinationStation())){
                    throw new IncorrectRouteCompositionException("Station:" + rc.getSegment().getDestinationStation().getName() + " - already used");
                }


            }

            lastRC = rc;

            depStations.add(rc.getSegment().getDepartureStation());
            desStations.add(rc.getSegment().getDestinationStation());
            usedStations.add(rc.getSegment().getDepartureStation());
        }

        if (desStations.size()<routeCompositions.size()){
            throw new IncorrectRouteCompositionException("departure station repeated");
        }

        if (depStations.size()<routeCompositions.size()){
            throw new IncorrectRouteCompositionException("destination station repeated");
        }
    }

    @Override
    public Route findByNumber(String routesNumber) {
        Route route = dao.findByNumber(routesNumber);
        return route;
    }

    @Override
    public void save(Route route) {
        dao.saveRoute(route);
    }

    @Override
    public Route findById(int routeId) {
        Route route = dao.findById(routeId);
        return route;
    }
}
