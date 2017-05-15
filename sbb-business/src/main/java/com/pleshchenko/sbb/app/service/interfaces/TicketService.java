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

    /**
     *
     * @param ticket
     * save ticket in DB
     */
    void save(Ticket ticket);

    /**
     *
     * @return a list of all tickets
     */
    List<Ticket> findAll();

    /**
     *
     * @param id
     * @return a list of ticket by id
     */
    Ticket findById(Integer id);

    /**
     *
     * @param st1 id of departure station
     * @param st2 id of destination station
     * @param dirId id of schedule
     * @param carId id of car
     * @param siteId namber of site
     * @param userName
     * @param depTime departure time
     * @param desTime destination time
     * @return
     */
    Ticket buyTicket(int st1,int st2,int dirId,int carId,int siteId,String userName,String desTime,String depTime);

    String getTicketsJSONById(int trainId);
}
