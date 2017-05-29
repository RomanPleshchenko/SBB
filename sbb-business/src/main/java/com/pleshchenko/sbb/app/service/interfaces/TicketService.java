package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.exception.RepeatingFieldsException;
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
     * @param json with atribute:
     * id of departure station
     * st2 id of destination station
     * dirId id of schedule
     * carId id of car
     * siteId namber of site
     * userName
     * depTime departure time
     * desTime destination time
     * @return ticket
     */
    Ticket buyTicket(String json) throws RepeatingFieldsException;

    String getTicketsJSONByTrainId(int trainId);

    String getTicketsJSONByUserSSO(String userSSO);
}
