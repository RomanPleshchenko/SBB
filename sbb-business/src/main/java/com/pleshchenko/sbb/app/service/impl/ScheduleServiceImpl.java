package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.ticket.Car;
import com.pleshchenko.sbb.app.entity.ticket.SitePrototype;
import com.pleshchenko.sbb.app.entity.ticket.TripsSite;
import com.pleshchenko.sbb.app.repositories.exceptions.NotEnoughParamsException;
import com.pleshchenko.sbb.app.repositories.interfaces.ScheduleDao;
import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
import com.pleshchenko.sbb.app.service.interfaces.TripsSiteService;
import com.pleshchenko.sbb.app.service.other.ParametersForSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Service("scheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    public Schedule findById(Integer id){
        return dao.findById(id);
    }

    @Autowired
    private ScheduleDao dao;

    @Autowired
    TripsSiteService tripsSiteService;

    @Override
    public List<Schedule> findAll() {
        List<Schedule> schedule = dao.findAll();
        return schedule;
    }

    @Override
    public String getScheduleJSONByParameters(int st1, int st2, Date data1, Date data2){
        String scheduleJSON = dao.getScheduleJSONByParameters(st1,st2,data1,data2);
        return scheduleJSON;
    }

    @Override
    public List findFreeSite(int st1, int st2, int dirId, int routeId) {
        List list = dao.findFreeSite(st1,st2,dirId,routeId);
        return list;
    }

    @Override
    public List<Schedule> findByStation(String stationName) {
        List<Schedule> schedule = dao.findByStation(stationName);
        return schedule;
    }

    @Override
    public void makeActive(int id) {

        Schedule dir = findById(id);
        dir.setActive(true);
        dao.save(dir);
    }

    @Override
    public void makeNotActive(int id) {

        Schedule dir = findById(id);
        dir.setActive(false);
        dao.save(dir);

    }

    @Override
    public void composeFreeSites(int id) {

        Schedule dir = findById(id);
        Set<Car> cars = dir.getTrain().getCars();
        Set<RouteComposition> routeCompositions = dir.getRoute().getRouteCompositions();

        for (Car car:cars){
            Set<SitePrototype> sitePrototypes = car.getCarPrototype().getSitePrototypes();
            for (SitePrototype sitePrototype:sitePrototypes){
                for (RouteComposition routeComposition:routeCompositions){
                    TripsSite tripsSite = new TripsSite(dir,car,routeComposition.getSegment(),sitePrototype);
                    tripsSiteService.save(tripsSite);
                }
            }
        }

        dir.setComposed(true);
        dao.save(dir);

    }

}
