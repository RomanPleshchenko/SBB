package com.pleshchenko.sbb.service.dto.impl;

import com.pleshchenko.sbb.model.model.entity.route.Schedule;
import com.pleshchenko.sbb.service.dao.interfaces.ScheduleDao;
import com.pleshchenko.sbb.service.dto.interfaces.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Service("scheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao dao;

    @Override
    public List<Schedule> findAll() {
        List<Schedule> schedule = dao.findAll();
        return schedule;
    }
}
