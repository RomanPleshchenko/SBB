package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.entity.Passenger;
import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.model.entity.Train;
import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.model.entity.route.Station;
import com.pleshchenko.sbb.service.dto.interfaces.PassengerService;
import com.pleshchenko.sbb.service.dto.interfaces.StationService;
import com.pleshchenko.sbb.service.dto.interfaces.TrainService;
import com.pleshchenko.sbb.service.dto.other.ParametersForSearch;
import com.pleshchenko.sbb.service.dto.interfaces.ScheduleService;
import com.pleshchenko.sbb.service.dto.other.SetId;
import com.pleshchenko.sbb.service.repositories.exceptions.NotEnoughParamsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Controller
@RequestMapping("/")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

    @RequestMapping(value = "/schedule",method = RequestMethod.GET)
    public String getSchedule(ModelMap model){

        List<Schedule> schedule = scheduleService.findAll();
        model.addAttribute("schedule",schedule);
        return "schedule";
    }

    @RequestMapping(value = "/scheduleByParameters",method = RequestMethod.POST)
    public ModelAndView scheduleByParameters(@Valid ParametersForSearch param, BindingResult result,
                                             ModelMap model){

        List<Schedule> schedule = scheduleService.findByParameters(param);
        model.addAttribute("schedule",schedule);
        return new ModelAndView("scheduleByParameters");

    }

    @RequestMapping(value = "/addToSchedule",method = RequestMethod.GET)
    public String addToSchedule(ModelMap model){

        List<Station> stations  = stationService.findAll();
        List<Train> trains = trainService.findAll();
        ParametersForSearch parametersForSearch = new ParametersForSearch();
        model.addAttribute("parametersForSearch",parametersForSearch);
        model.addAttribute("stations", stationService.findAll());
        model.addAttribute("trains",trains);

        return "addToSchedule";
    }


    @RequestMapping(value = "/addToSchedule",method = RequestMethod.POST)
    public String addToSchedule(@Valid ParametersForSearch param, BindingResult result,
                                      ModelMap model){

        try {
            Schedule schedule = scheduleService.addByParameters(param);
            return RequestType.REDIRECT + "schedule";
        } catch (NotEnoughParamsException e) {
            model.addAttribute("error",e.getMessage());
            return "addToSchedule";
        }

    }

}




