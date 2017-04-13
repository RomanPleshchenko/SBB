package com.pleshchenko.sbb.service.impl;

import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.repositories.interfaces.TicketDao;
import com.pleshchenko.sbb.service.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 08.04.2017.
 */
@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao dao;

    @Override
    public void save(Ticket ticket) {
        dao.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> tickets = dao.findAll();
        return tickets;
    }

    @Override
    public Ticket findById(Integer idSchedule, Integer idPassenger) {
        Ticket  ticket = dao.findById(idSchedule,idPassenger);
        return ticket;
    }
}
