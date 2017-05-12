package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 08.04.2017.
 */
@Service("ticketService")
@Transactional
public interface TicketService {

    void save(Ticket ticket);

    List<Ticket> findAll();

    Ticket findById(Integer idSchedule,Integer idPassenger);

    Ticket buyTicket(int st1,int st2,int dirId,int carId,int siteId,String userName);
}
