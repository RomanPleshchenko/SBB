package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.ticket.Train;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.service.interfaces.PassengerService;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
import com.pleshchenko.sbb.app.service.interfaces.TrainService;
import com.pleshchenko.sbb.app.service.other.ParametersForSearch;
import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
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

    @RequestMapping(value = "/getScheduleJSON", method = RequestMethod.GET)
    public @ResponseBody String showData(@RequestParam("st1") int st1, @RequestParam("st2") int st2,
                                         @RequestParam("date1") String date1,@RequestParam("date2") String date2, Model model) throws JSONException {

        Date dat1 = Date.valueOf(date1);
        Date dat2 = Date.valueOf(date2);

        String scheduleJSON = scheduleService.getScheduleJSONByParameters(st1,st2,dat1,dat2);
        return scheduleJSON;

    }

}


