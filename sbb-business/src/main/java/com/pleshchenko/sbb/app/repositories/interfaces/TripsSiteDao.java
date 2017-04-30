package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.ticket.TripsSite;

import java.util.List;

/**
 * Created by РОМАН on 30.04.2017.
 */
public interface TripsSiteDao {

    List<TripsSite> findBySchedule(Schedule schedule);

    void save (TripsSite tripsSite);

    void delete (TripsSite tripsSite);
}
