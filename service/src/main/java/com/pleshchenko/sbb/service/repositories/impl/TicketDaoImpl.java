package com.pleshchenko.sbb.service.repositories.impl;

import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.service.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.repositories.interfaces.TicketDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 08.04.2017.
 */
@Repository("ticketDao")
public class TicketDaoImpl extends AbstractDao<Integer,Ticket> implements TicketDao {
    @Override
    public List<Ticket> findAll() {
        List<Ticket> tickets = getEntityManager()
                .createQuery("SELECT t FROM Ticket t")
                .getResultList();
        return tickets;
    }

    @Override
    public void save(Ticket ticket) {
        persist(ticket);
    }

    @Override
    public Ticket findById(Integer idSchedule, Integer idPassenger) {
        List<Ticket> tickets = getEntityManager()
                .createQuery("SELECT t FROM Ticket t WHERE t.passenger.id = "
                        + idPassenger + " AND t.schedule.id = " + idSchedule)
                .getResultList();
        if (tickets.size()==0)
            return null;
        else
            return tickets.get(0);
    }
}
