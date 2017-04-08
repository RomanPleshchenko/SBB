package com.pleshchenko.sbb.service.dto.impl;

import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.service.dao.interfaces.TicketDao;
import com.pleshchenko.sbb.service.dto.interfaces.TicketService;
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
    public List<Ticket> findAll() {
        List<Ticket> tickets = dao.findAll();
        return tickets;
    }
}
