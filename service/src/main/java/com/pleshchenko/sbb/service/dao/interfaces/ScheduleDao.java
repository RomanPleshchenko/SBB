package com.pleshchenko.sbb.service.dao.interfaces;

import com.pleshchenko.sbb.model.model.entity.route.Schedule;

import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
public interface ScheduleDao {

    List<Schedule> findAll();
}
