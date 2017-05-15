package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.ticket.TripsSite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 30.04.2017.
 */
@Service("tripsSiteService")
@Transactional
public interface TripsSiteService {

    /**
     *
     * @param schedule
     * @return a list of all schedule
     */
    public List<TripsSite> findBySchedule(Schedule schedule);

    /**
     * save trip site in DB
     * @param tripsSite
     */
    void save(TripsSite tripsSite);

}
