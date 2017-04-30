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
    public List<Schedule> findByStation(String stationName) {
        List<Schedule> schedule = dao.findByStation(stationName);
        return schedule;
    }

    @Override
    public void makeActive(int id) {

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

        dir.setActive(true);
        dao.save(dir);
    }


    @Override
    public void makeNotActive(int id) {

        Schedule dir = findById(id);
        List<TripsSite> tripsSites = tripsSiteService.findBySchedule(dir);

        for (TripsSite tripsSite:tripsSites) {
            tripsSiteService.delete(tripsSite);
        }

        dir.setActive(false);
        dao.save(dir);

    }

//    @Override
//    public List<Schedule> findByParameters(ParametersForSearch param) {
//        List<Schedule> schedule = dao.findByParameters(param);
//        return schedule;
//    }
//
//    @Override
//    public Schedule addByParameters(ParametersForSearch param) throws NotEnoughParamsException {
//        Schedule schedule = dao.addByParameters(param);
//        return schedule;
//    }

}
