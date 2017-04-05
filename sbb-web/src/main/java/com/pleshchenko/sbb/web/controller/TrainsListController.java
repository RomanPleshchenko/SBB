package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.model.entity.Train;
import com.pleshchenko.sbb.service.interfaces.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Controller
@RequestMapping("/")
public class TrainsListController {

    @Autowired
    TrainService trainService;

    @RequestMapping(value = "/trains",method = RequestMethod.GET)
    public String goHome(ModelMap model){

        List<Train> trains  = trainService.findAll();

        model.addAttribute("trains", trains);
        return "trainslist";
    }


}
