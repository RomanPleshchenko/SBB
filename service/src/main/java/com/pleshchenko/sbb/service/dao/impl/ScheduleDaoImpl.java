package com.pleshchenko.sbb.service.dao.impl;

import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.service.dao.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.dao.interfaces.ScheduleDao;
import com.pleshchenko.sbb.service.dto.other.ParametersForSearch;
import org.springframework.stereotype.Repository;
import java.time.Instant;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Repository("scheduleDaoImpl")
public class ScheduleDaoImpl extends AbstractDao<Integer,Schedule> implements ScheduleDao{
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
}
