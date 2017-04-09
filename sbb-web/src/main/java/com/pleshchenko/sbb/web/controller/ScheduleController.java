package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.entity.Passenger;
import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.model.entity.Train;
import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.service.dto.interfaces.PassengerService;
import com.pleshchenko.sbb.service.dto.other.ParametersForSearch;
import com.pleshchenko.sbb.service.dto.interfaces.ScheduleService;
import com.pleshchenko.sbb.service.dto.other.SetId;
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

    @RequestMapping(value = "/schedule",method = RequestMethod.GET)
    public String getSchedule(ModelMap model){

        List<Schedule> schedule = scheduleService.findAll();
        model.addAttribute("schedule",schedule);
        return "schedule";
    }

    @RequestMapping(value = "/scheduleByParameters",method = RequestMethod.GET)
    public ModelAndView scheduleByParameters(@Valid ParametersForSearch param, BindingResult result,
                                             ModelMap model){

        List<Schedule> schedule = scheduleService.findByParameters(param);
        model.addAttribute("schedule",schedule);
//        return new ModelAndView("scheduleByParameters","set",set);
        return new ModelAndView("scheduleByParameters");

    }

}
