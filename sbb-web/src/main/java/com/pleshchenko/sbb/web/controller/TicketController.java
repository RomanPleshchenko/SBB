package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.entity.Passenger;
import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.model.service.interfaces.PassengerService;
import com.pleshchenko.sbb.model.service.interfaces.ScheduleService;
import com.pleshchenko.sbb.model.service.interfaces.TicketService;
import com.pleshchenko.sbb.model.service.other.SetId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Controller
@RequestMapping("/")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/tickets",method = RequestMethod.GET)
    public String goTicketsLis(ModelMap model){
        List<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets",tickets);
        return "ticketslist";
    }

    @RequestMapping(value = {"/saveTicket-{idShedule}"}, method = RequestMethod.GET)
    public String saveTicket(ModelMap model,@ModelAttribute("set") SetId set,@PathVariable String idShedule) {

        Ticket ticket;

        Integer idSchedule = Integer.parseInt(idShedule);
        Integer idPassenger = set.getId1();

        ticket = ticketService.findById(idSchedule,idPassenger);
        if (ticket==null){
            Schedule schedule = scheduleService.findById(idSchedule);
            Passenger passenger = passengerService.findById(idPassenger);
            ticket = new Ticket();
            ticket.setSchedule(schedule);
            ticket.setPassenger(passenger);
            ticketService.save(ticket);
            return RequestType.REDIRECT + "tickets";
        }else{
            model.addAttribute("message","You can not buy two tickets for one trip");
            return "notification";
        }
    }

    @RequestMapping(value = { "/buy-ticket-{id}" }, method = RequestMethod.GET)
    public ModelAndView saveTicket(ModelMap model, @PathVariable String id) {

        List<Passenger> passengers = passengerService.findAll();
        model.addAttribute("passengers",passengers);
        model.addAttribute("idShedule",id);
        return new ModelAndView("selectPassenger","set",new SetId());
    }
}
