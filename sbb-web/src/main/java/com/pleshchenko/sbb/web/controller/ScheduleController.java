package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.model.entity.route.Schedule;
import com.pleshchenko.sbb.service.dto.impl.ParametersForSearch;
import com.pleshchenko.sbb.service.dto.interfaces.ScheduleService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

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

//    @RequestMapping(value = "/findTrainByParameter",method = RequestMethod.POST)
//    public String findTrainByParameter(@Valid ParametersForSearch parametersForSearch, BindingResult result,
//                                       ModelMap model){
//
//        parametersForSearch = new ParametersForSearch();//?????
//
//        parametersForSearch.setStation1("Moscow");
//        parametersForSearch.setStation2("Berlin");
//
//        Timestamp date1 = new Timestamp(2017-1900,4-1,6,10-1,0,0,0);
//        Timestamp date2 = new Timestamp(2017-1900,4-1,8,10-1,0,0,0);
//        parametersForSearch.setData1(date1);
//        parametersForSearch.setData1(date2);
//
//
//
//        model.addAttribute("parametersForSearch",parametersForSearch);
//        return "trainByParameter";
//    }

    @RequestMapping(value = "/findTrainByParameter",method = RequestMethod.POST)
    public String saveStation(final Model model, @ModelAttribute("parametersForSearch") ParametersForSearch parametersForSearch) throws ServiceException {


        //model.addAttribute("parametersForSearch",parametersForSearch);
        return "trainByParameter";
    }



}
