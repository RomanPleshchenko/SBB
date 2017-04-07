package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.model.entity.route.Schedule;
import com.pleshchenko.sbb.model.model.otherClasses.ParametersForSearch;
import com.pleshchenko.sbb.service.interfaces.ScheduleService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/schedule",method = RequestMethod.GET)
    public String getSchedule(ModelMap model){

        List<Schedule> schedule = scheduleService.findAll();
        model.addAttribute("schedule",schedule);
        return "schedule";
    }

    @RequestMapping(value = "/findTrainByParameter",method = RequestMethod.POST)
    public String findTrainByParameter(@Valid ParametersForSearch parametersForSearch, BindingResult result,
                                       ModelMap model){

        parametersForSearch = new ParametersForSearch();//?????
        parametersForSearch.setStation1("Moscow");
        parametersForSearch.setStation2("Berlin");

        DateTime date1 = new DateTime();



        model.addAttribute("parametersForSearch",parametersForSearch);
        return "trainByParameter";
    }

}
