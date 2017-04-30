package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.ticket.TripsSite;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.TripsSiteDao;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

/**
 * Created by РОМАН on 30.04.2017.
 */
@Repository("TripsSiteDao")
public class TripsSiteDaoImpl extends AbstractDao<Integer,TripsSite> implements TripsSiteDao {

    @Override
    public List<TripsSite> findBySchedule(Schedule schedule) {
        Query query = getEntityManager()
                .createQuery("SELECT t FROM TripsSite t " +
                        "WHERE t.schedule = :schedule");
        query.setParameter("schedule",schedule);

        List<TripsSite> tripsSites = query.getResultList();

        return tripsSites;
    }

    @Override
    public void save(TripsSite tripsSite) {
        persist(tripsSite);
    }

    @Override
    public void delete(TripsSite tripsSite) {
        delete(tripsSite);
    }
}
