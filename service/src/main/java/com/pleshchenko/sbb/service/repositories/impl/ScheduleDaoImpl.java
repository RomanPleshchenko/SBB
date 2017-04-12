package com.pleshchenko.sbb.service.repositories.impl;

import com.pleshchenko.sbb.model.entity.Train;
import com.pleshchenko.sbb.model.entity.route.Route;
import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.model.entity.route.Station;
import com.pleshchenko.sbb.service.dto.interfaces.RouteService;
import com.pleshchenko.sbb.service.dto.interfaces.StationService;
import com.pleshchenko.sbb.service.dto.interfaces.TrainService;
import com.pleshchenko.sbb.service.repositories.exceptions.NotEnoughParamsException;
import com.pleshchenko.sbb.service.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.repositories.interfaces.ScheduleDao;
import com.pleshchenko.sbb.service.dto.other.ParametersForSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.Instant;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Repository("scheduleDaoImpl")
public class ScheduleDaoImpl extends AbstractDao<Integer,Schedule> implements ScheduleDao{

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

    @Autowired
    RouteService routeService;

    @Override
    public Schedule findById(Integer id) {
        return getByKey(id);
    }

    @Override
    public List<Schedule> findAll() {

        List<Schedule> schedule = getEntityManager()
                .createQuery("SELECT s FROM Schedule s ORDER BY s.departureTime")
                .getResultList();
        return schedule;

    }

    @Override
    public List<Schedule> findByStation(String stationName) {


        List<Schedule> schedule = getEntityManager()
                .createQuery("SELECT s FROM Schedule s WHERE s.route.departureStation.name LIKE '" + stationName + "'")
                .getResultList();
        return schedule;
    }

    @Override
    public List<Schedule> findByParameters(ParametersForSearch param) {

        Query query = getEntityManager()
                .createQuery("SELECT s FROM Schedule s " +
                        "WHERE s.route.departureStation.id = :departureStationid " +
                        "AND s.route.destinationStation.id = :destinationStationid " +
                        "AND s.departureTime >= :data1 " +
                        "AND s.departureTime <= :data2 " +
                        "ORDER BY s.departureTime");

        query.setParameter("departureStationid",param.getStation1());
        query.setParameter("destinationStationid",param.getStation2());
        query.setParameter("data1",Instant.ofEpochMilli(param.getData1().getTime()));
        query.setParameter("data2",Instant.ofEpochMilli(param.getData2().getTime()));

        List<Schedule> schedule = query.getResultList();

        return schedule;
    }

    @Override
    public Schedule addByParameters(ParametersForSearch param) throws NotEnoughParamsException {

        if (param.getData1()==null|param.getData2()==null|param.getStation1()==null|param.getStation2()==null|param.getTrain()==null){
            throw new NotEnoughParamsException("        You must fill in all the fields!!!!!");
        }

        Train train = trainService.findByNumber(param.getTrain());
        Station station1 = stationService.findById(param.getStation1());
        Station station2 = stationService.findById(param.getStation1());

        Route route = routeService.findByStation(station1,station2,true);

        Schedule schedule = new Schedule();
        schedule.setDepartureTime(param.getData1().toInstant());
        schedule.setDestinationTime(param.getData2().toInstant());
        schedule.setTrain(train);
        schedule.setRoute(route);

        persist(schedule);
        return schedule;
    }
}
