package com.pleshchenko.sbb.service.dao.impl;

import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.service.dao.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.dao.interfaces.TicketDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 08.04.2017.
 */
@Repository("ticketDao")
public class TicketDaoImpl extends AbstractDao<Integer,Ticket> implements TicketDao {
    @Override
    public List<Ticket> findAll() {
        List<Ticket> ticket = getEntityManager()
                .createQuery("SELECT t FROM Ticket t")
                .getResultList();
        return ticket;
    }
}
