package com.pleshchenko.sbb.service.dao.interfaces;

import com.pleshchenko.sbb.model.entity.Ticket;

import java.util.List;

/**
 * Created by РОМАН on 08.04.2017.
 */
public interface TicketDao {

    List<Ticket> findAll();
}
