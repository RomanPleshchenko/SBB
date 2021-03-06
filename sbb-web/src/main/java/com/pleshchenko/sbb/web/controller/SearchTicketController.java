package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by РОМАН on 12.04.2017.
 */
@Controller
@RequestMapping("/")
public class SearchTicketController {

    @Autowired
    StationService stationService;

    @RequestMapping("/searchTicket")
    public String goSearchTicket(ModelMap model){

        List<Station> stations  = stationService.findAll();
        model.addAttribute("stations", stationService.findAll());
        return "searchTicket";
    }

}
