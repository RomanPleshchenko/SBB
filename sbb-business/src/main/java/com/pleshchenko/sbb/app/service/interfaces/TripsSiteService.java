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

    public List<TripsSite> findBySchedule(Schedule schedule);

    void save(TripsSite tripsSite);

    public void delete(TripsSite tripsSite);
}
