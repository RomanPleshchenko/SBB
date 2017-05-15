package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.repositories.interfaces.TicketDao;
import com.pleshchenko.sbb.app.service.interfaces.TicketService;
import org.json.JSONArray;
import org.json.JSONObject;
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
    public Ticket findById(Integer id) {
        Ticket ticket = dao.findById(id);
        return ticket;
    }

    @Override
    public Ticket buyTicket(int st1, int st2, int dirId, int carId, int siteId, String userName, String desTime, String depTime) {
        Ticket ticket = dao.buyTicket(st1, st2, dirId, carId, siteId, userName, desTime, depTime);
        return ticket;
    }

    @Override
    public String getTicketsJSONByTrainId(int userId) {

        List<Ticket> tickets = dao.getTicketsByTrainId(userId);

        JSONArray ticketArray = new JSONArray();

        for (Ticket ticket:tickets) {

            JSONObject ticketJSON = new JSONObject();

            ticketJSON.put("ticketId",ticket.getId());
            ticketJSON.put("trainNumber",ticket.getTrain().getNumber());
            ticketJSON.put("destinationStation",ticket.getDestinationStation().getName());
            ticketJSON.put("departureStation",ticket.getDepartureStation().getName());
            ticketJSON.put("destinationTime",ticket.getDestinationTime().plusSeconds(3600*3).toString());
            ticketJSON.put("departureTime",ticket.getDepartureTime().plusSeconds(3600*3).toString());
            ticketJSON.put("passenger",ticket.getUser().getFirstName() + " " + ticket.getUser().getLastName());

            ticketArray.put(ticketJSON);

        }

        return ticketArray.toString();
    }

    @Override
    public String getTicketsJSONByUserSSO(String userSSO) {

        List<Ticket> tickets = dao.getTicketsByUserSSO(userSSO);

        JSONArray ticketArray = new JSONArray();

        for (Ticket ticket:tickets) {

            JSONObject ticketJSON = new JSONObject();

            ticketJSON.put("ticketId",ticket.getId());
            ticketJSON.put("trainNumber",ticket.getTrain().getNumber());
            ticketJSON.put("destinationStation",ticket.getDestinationStation().getName());
            ticketJSON.put("departureStation",ticket.getDepartureStation().getName());
            ticketJSON.put("destinationTime",ticket.getDestinationTime().plusSeconds(3600*3).toString());
            ticketJSON.put("departureTime",ticket.getDepartureTime().plusSeconds(3600*3).toString());

            ticketArray.put(ticketJSON);

        }

        return ticketArray.toString();

    }
}