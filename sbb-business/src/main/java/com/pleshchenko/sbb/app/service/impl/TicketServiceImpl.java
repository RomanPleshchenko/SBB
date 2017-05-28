package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.exception.ExistingTicketException;
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
    public Ticket buyTicket(String json) throws ExistingTicketException {

        JSONObject jsonObject = new JSONObject(json);

        int st1 = Integer.parseInt((String)jsonObject.get("st1"));
        int st2 = Integer.parseInt((String)jsonObject.get("st2"));
        int dirId = Integer.parseInt((String)jsonObject.get("dirId"));
        int carId = Integer.parseInt((String)jsonObject.get("carNumber"));
        int siteId = Integer.parseInt((String)jsonObject.get("siteId"));
        String userName = (String)jsonObject.get("userName");
        String depTime = (String)jsonObject.get("departureTimeInFormat");
        String desTime = (String)jsonObject.get("destinationTimeInFormat");

        Ticket existingTicket = dao.findByUserNamedirId(userName,dirId);

        if (existingTicket!=null){
            throw new ExistingTicketException("Existing a ticket for car: " + carId + " site number: " + siteId);
        }

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
            ticketJSON.put("plasesNumber",ticket.getPlasesNumber());
            ticketJSON.put("trainNumber",ticket.getTrain().getNumber());
            ticketJSON.put("departureStation",ticket.getDepartureStation().getName());
            ticketJSON.put("destinationStation",ticket.getDestinationStation().getName());
            ticketJSON.put("departureTime",ticket.getDepartureTime().plusSeconds(3600*3).toString());
            ticketJSON.put("destinationTime",ticket.getDestinationTime().plusSeconds(3600*3).toString());
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
            ticketJSON.put("plasesNumber",ticket.getPlasesNumber());
            ticketJSON.put("trainNumber",ticket.getTrain().getNumber());
            ticketJSON.put("departureStation",ticket.getDepartureStation().getName());
            ticketJSON.put("destinationStation",ticket.getDestinationStation().getName());
            ticketJSON.put("departureTime",ticket.getDepartureTime().plusSeconds(3600*3).toString());
            ticketJSON.put("destinationTime",ticket.getDestinationTime().plusSeconds(3600*3).toString());


            ticketArray.put(ticketJSON);

        }

        return ticketArray.toString();

    }
}