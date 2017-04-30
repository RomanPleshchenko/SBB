package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.ticket.TripsSite;
import com.pleshchenko.sbb.app.repositories.interfaces.TripsSiteDao;
import com.pleshchenko.sbb.app.service.interfaces.TripsSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 30.04.2017.
 */
@Service("tripsSiteService")
@Transactional
public class TripsSiteServiceImpl implements TripsSiteService {

    @Autowired
    private TripsSiteDao dao;

    @Override
    public List<TripsSite> findBySchedule(Schedule schedule) {
        List<TripsSite> tripsSites = dao.findBySchedule(schedule);
        return tripsSites;
    }

    @Override
    public void save(TripsSite tripsSite) {
        dao.save(tripsSite);
    }

    @Override
    public void delete(TripsSite tripsSite) {
        dao.delete(tripsSite);
    }


}
