package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.repositories.interfaces.TicketDao;
import com.pleshchenko.sbb.app.service.interfaces.TicketService;
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

    @Override
    public Ticket buyTicket(int st1, int st2, int dirId, int carId, int siteId, String userName) {
        Ticket ticket = dao.buyTicket(st1,st2,dirId,carId,siteId,userName);
        return ticket;
    }
}
