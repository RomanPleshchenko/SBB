package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.ScheduleDao;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
import com.pleshchenko.sbb.app.service.interfaces.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.sql.Date;

import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */

@Repository("scheduleDao")
public class ScheduleDaoImpl extends AbstractDao<Integer,Schedule> implements ScheduleDao {

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

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

    public List<Schedule> findByParameters(int st1,int st2,Date data1,Date data2) {

        String NATIVE_QUERY = "SELECT \n" +
                "    dir.id, dir.active, dir.routeId, dir.trainId, dir.departureTime, dir.destinationTime\n" +
                "FROM \n" +
                "\tschedule dir      \n" +
                "LEFT JOIN \n" +
                "\n" +
                "(SELECT \n" +
                "    r.id routeId, \n" +
                "    s.departureStationId stId,\n" +
                "    rc.departureTime depTime\n" +
                "FROM route r LEFT JOIN routeComposition rc on r.id=rc.routeId LEFT JOIN segment s on rc.segmentId=s.id) t1 ON t1.stId = :st1\n" +
                "\n" +
                "LEFT JOIN \n" +
                "\n" +
                "(SELECT \n" +
                "    r.id routeId, \n" +
                "    s.departureStationId stId,\n" +
                "    rc.departureTime depTime\n" +
                "FROM route r LEFT JOIN routeComposition rc on r.id=rc.routeId LEFT JOIN segment s on rc.segmentId=s.id) t2 ON t2.stId = :st2\n" +
                "  \n" +
                " WHERE t1.depTime < t2.depTime";

        return getEntityManager()
                .createNativeQuery(NATIVE_QUERY, Schedule.class)
                .setParameter("st1",st1)
                .setParameter("st2",st2)
                .getResultList();
    }

    @Override
    public List<Schedule> findByStation(String stationName) {


        List<Schedule> schedule = getEntityManager()
                .createQuery("SELECT s FROM Schedule s WHERE s.segment.departureStation.name LIKE '" + stationName + "'")
                .getResultList();
        return schedule;
    }

    @Override
    public void save(Schedule dir){
        persist(dir);
    }

    private Instant dateToInstant(Date date){
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return instant;
    }
}

