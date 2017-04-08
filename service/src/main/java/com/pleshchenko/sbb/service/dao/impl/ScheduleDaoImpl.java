package com.pleshchenko.sbb.service.dao.impl;

import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.service.dao.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.dao.interfaces.ScheduleDao;
import com.pleshchenko.sbb.service.dto.other.ParametersForSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Repository("scheduleDaoImpl")
public class ScheduleDaoImpl extends AbstractDao<Integer,Schedule> implements ScheduleDao{
    @Override
    public List<Schedule> findAll() {

        List<Schedule> schedule = getEntityManager()
                .createQuery("SELECT s FROM Schedule s ORDER BY s.departureTime")
                .getResultList();
        return schedule;

    }

    @Override
    public List<Schedule> findByParameters(ParametersForSearch param) {

        //????? задать параметры нормально
        List<Schedule> schedule = getEntityManager()
                .createQuery("SELECT s FROM Schedule s " +
                        "WHERE s.route.departureStation.id = " + param.getStation1() + " AND s.route.destinationStation.id = " + param.getStation2() + "  ORDER BY s.departureTime")
                .getResultList();
        return schedule;

    }
}
