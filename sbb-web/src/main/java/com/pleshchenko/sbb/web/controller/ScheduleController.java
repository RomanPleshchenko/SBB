package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.ticket.Train;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.service.interfaces.PassengerService;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
import com.pleshchenko.sbb.app.service.interfaces.TrainService;
import com.pleshchenko.sbb.app.service.other.ParametersForSearch;
import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
import com.pleshchenko.sbb.app.repositories.exceptions.NotEnoughParamsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.NotSupportedException;
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
    public String scheduleByParameters(@Valid ParametersForSearch param, BindingResult result,
                                             ModelMap model) throws NotSupportedException {


//        if (param.getData1()==null|param.getData2()==null|param.getStation1()==null|param.getStation2()==null){
        if (param.getStation1()==null|param.getStation2()==null){

            List<Station> stations  = stationService.findAll();
            ParametersForSearch parametersForSearch = new ParametersForSearch();
            model.addAttribute("parametersForSearch",parametersForSearch);
            model.addAttribute("stations", stationService.findAll());
            model.addAttribute("error","            You must fill in all the fields!!!!!");
            return "searchTicket";
        }
        List<Schedule> schedule = scheduleService.findByParameters(param.getStation1(),param.getStation2(),param.getData1(),param.getData2());
        model.addAttribute("schedule",schedule);
//        return "scheduleByParameters";???????????
        return "schedule";


    }

    @RequestMapping(value = "/addToSchedule",method = RequestMethod.GET)
    public String addToSchedule(ModelMap model){

        fillModel(model);
        return "addToSchedule";
    }


    @RequestMapping(value = "/addToSchedule",method = RequestMethod.POST)
    public String addToSchedule(@Valid ParametersForSearch param, BindingResult result,
                                      ModelMap model) throws NotSupportedException {
//
//        try {
//            Schedule schedule = scheduleService.addByParameters(param);
//            return RequestType.REDIRECT + "schedule";
//        } catch (NotEnoughParamsException e) {
//
//            fillModel(model);
//            model.addAttribute("error",e.getMessage());
//            return "addToSchedule";
//        }

        throw new NotSupportedException("");

    }

    private void fillModel(ModelMap model){

        List<Station> stations  = stationService.findAll();
        List<Train> trains = trainService.findAll();
        ParametersForSearch parametersForSearch = new ParametersForSearch();
        model.addAttribute("parametersForSearch",parametersForSearch);
        model.addAttribute("stations", stationService.findAll());
        model.addAttribute("trains",trains);
    }

    @RequestMapping(value = { "/make-active-dir-{id}" }, method = RequestMethod.GET)
    public String makeActive(@PathVariable int id, ModelMap model) {

        scheduleService.makeActive(id);
        return RequestType.REDIRECT + "schedule";

    }

    @RequestMapping(value = { "/make-not-active-dir-{id}" }, method = RequestMethod.GET)
    public String makeNotActive(@PathVariable int id, ModelMap model) {

        scheduleService.makeNotActive(id);
        return RequestType.REDIRECT + "schedule";

    }



}




