package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.Ticket;

import java.util.List;

/**
 * Created by РОМАН on 08.04.2017.
 */
public interface TicketDao {

    List<Ticket> findAll();

    void save(Ticket ticket);

    Ticket findById(Integer idSchedule,Integer idPassenger);

    Ticket buyTicket(int st1,int st2,int dirId,int carId,int siteId,String userName);
}
