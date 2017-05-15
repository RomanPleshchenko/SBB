package com.pleshchenko.sbb.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
import com.pleshchenko.sbb.app.temp.StationJsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

    @RequestMapping(value = {"/newStation"}, method = RequestMethod.POST)
    public String addNewTrainByParameters(@Valid @ModelAttribute("station") Station station,BindingResult bindingResult,ModelMap model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error","You must fill in all the fields");
            return "newStation";
        }

        if (stationService.findByName(station.getName())!=null){
            model.addAttribute("error","station " + station.getName() + " already exists");
            return "newStation";
        }

        stationService.saveStation(station);
        return RequestType.REDIRECT + "stations";
    }


    /////???????????? убрать все лишнее в сервисы

    @RequestMapping(value = "/getStationslist", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getStationslist(HttpServletRequest request) throws IOException {

        Integer pageNumber = 0;
        if (null != request.getParameter("iDisplayStart"))
            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/10)+1;

        String searchParameter = request.getParameter("sSearch");

        Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));

        List<Station> stationslist = stationService.findAll(pageNumber,searchParameter,pageDisplayLength);

        StationJsonObject personJsonObject = new StationJsonObject();

        personJsonObject.setiTotalDisplayRecords(stationService.getCount().intValue());
        personJsonObject.setiTotalRecords(stationService.getCount().intValue());
        personJsonObject.setAaData(stationslist);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(personJsonObject);

        return json2;
    }


    @RequestMapping("/getStationslistJSON")
    @ResponseBody public String getStationslistJSON(){

        String ticketListJSON = stationService.getStationslistJSON();
        return ticketListJSON;
    }

}
