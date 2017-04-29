package com.pleshchenko.sbb.app.repositories.impl;


//import com.pleshchenko.sbb.app.entity.schedule.Segment;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
//import com.pleshchenko.sbb.app.entity.schedule.Station;
//import com.pleshchenko.sbb.app.repositories.exceptions.NotEnoughParamsException;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.ScheduleDao;
//import com.pleshchenko.sbb.app.service.interfaces.SegmentService;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
import com.pleshchenko.sbb.app.service.interfaces.TrainService;
//import com.pleshchenko.sbb.app.service.other.ParametersForSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.Instant;
//import java.time.temporal.ChronoUnit;
import java.sql.Date;
//import com.pleshchenko.sbb.app.entity.ticket.Ticket;
//import com.pleshchenko.sbb.app.entity.ticket.Train;

//import javax.persistence.Query;
//import java.util.Collections;
import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Repository("scheduleDaoImpl")
public class ScheduleDaoImpl extends AbstractDao<Integer,Schedule> implements ScheduleDao {

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

//    @Autowired
//    SegmentService segmentService;

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
                .createQuery("SELECT s FROM Schedule s WHERE s.segment.departureStation.name LIKE '" + stationName + "'")
                .getResultList();
        return schedule;
    }

//    @Override
//    public List<Schedule> findByParameters(ParametersForSearch param) {
//
//        Query query = getEntityManager()
//                .createQuery("SELECT s FROM Schedule s " +
//                        "WHERE s.segment.departureStation.id = :departureStationid " +
//                        "AND s.segment.destinationStation.id = :destinationStationid " +
//                        "AND s.departureTime >= :data1 " +
//                        "AND s.departureTime < :data2 " +
//                        "ORDER BY s.departureTime");
//
//        query.setParameter("departureStationid",param.getStation1());
//        query.setParameter("destinationStationid",param.getStation2());
//        query.setParameter("data1",dateToInstant(param.getData1()));
//        query.setParameter("data2",dateToInstant(param.getData2()).plus(24,ChronoUnit.HOURS));
//
//        List<Schedule> schedule = query.getResultList();
//
//        return schedule;
//    }

//    @Override
//    public Schedule addByParameters(ParametersForSearch param) throws NotEnoughParamsException {
//
//        if (param.getData1()==null|param.getData2()==null|param.getStation1()==null|param.getStation2()==null|param.getTrain()==null){
//            throw new NotEnoughParamsException("            You must fill in all the fields!!!!!");
//        }
//
//        Train train = trainService.findByNumber(param.getTrain());
//        Station station1 = stationService.findById(param.getStation1());
//        Station station2 = stationService.findById(param.getStation2());
//
//        Segment segment = segmentService.findByStation(station1,station2,true);
//
//
//        Schedule schedule = new Schedule();
//        schedule.setDepartureTime(dateToInstant(param.getData1()));
//        schedule.setDestinationTime(dateToInstant(param.getData2()));
//        schedule.setTrain(train);
//        schedule.setSegment(segment);
//
//        List<Ticket> tickets = Collections.emptyList();
//        schedule.setTickets(tickets);
//
//        persist(schedule);
//        return schedule;
//    }

    private Instant dateToInstant(Date date){
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return instant;
    }
}
