package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.service.dto.interfaces.TicketService;
import com.pleshchenko.sbb.service.dto.other.SetId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Controller
@RequestMapping("/")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/tickets",method = RequestMethod.GET)
    public String goTicketsLis(ModelMap model){
        System.out.println("попадаем");
        List<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets",tickets);
        return "ticketslist";
    }


    @RequestMapping(value = {"/saveTicket"}, method = RequestMethod.POST)
    public String saveTicket(@ModelAttribute("set") SetId set) {

        System.out.println(set.getId1());
        System.out.println("it work");

        return "tickets";
    }


}
