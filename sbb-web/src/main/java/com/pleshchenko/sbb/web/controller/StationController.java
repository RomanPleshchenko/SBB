package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.model.entity.route.Station;
import com.pleshchenko.sbb.service.dto.interfaces.ScheduleService;
import com.pleshchenko.sbb.service.dto.interfaces.StationService;
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
 * Created by РОМАН on 11.04.2017.
 */
@Controller
@RequestMapping("/")
public class StationController {

    @Autowired
    StationService stationService;

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/stations",method = RequestMethod.GET)
    public String goStationslist(ModelMap model){

        List<Station> stations  = stationService.findAll();
        model.addAttribute("stations", stations);
        return "stationsList";
    }

    @RequestMapping(value = { "/go-schedule-{stationsName}" }, method = RequestMethod.GET)
    public ModelAndView goStationslistByParam(@PathVariable String stationsName,ModelMap model) {

        List<Schedule> schedule = scheduleService.findByStation(stationsName);
        model.addAttribute("schedule",schedule);
        return new ModelAndView("schedule");
    }

    @RequestMapping(value = {"/newStation"}, method = RequestMethod.GET)
    public ModelAndView addNewStation() {
        return new ModelAndView("newStation","station",new Station());
    }

    @RequestMapping(value = {"/addNewStationByParameters"}, method = RequestMethod.GET)
    public String addNewTrainByParameters(@ModelAttribute("station") Station station) {
        //???? добавить проверки на то что что такого поезда нет
        //тоже не возвращает обратно
        stationService.saveStation(station);
        return "stationsList";
    }
}
