package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.model.entity.Train;
import com.pleshchenko.sbb.service.dto.interfaces.TrainService;
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
 * Created by РОМАН on 05.04.2017.
 */
@Controller
@RequestMapping("/")
public class TrainsController {

    @Autowired
    TrainService trainService;

    @RequestMapping(value = "/trains",method = RequestMethod.GET)
    public String goTrainslist(ModelMap model){

        List<Train> trains  = trainService.findAll();
        model.addAttribute("trains", trains);
        return "trainslist";
    }

    @RequestMapping(value = { "/delete-train-{number}" }, method = RequestMethod.GET)
    public String deleteTrain(@PathVariable String number,ModelMap model) {

        try {
            trainService.deleteByNumber(number);
            return RequestType.REDIRECT + "trains";
        }catch (Exception e){
            model.addAttribute("message","You cannot delete this train!!!");
            return "notification";
        }
    }

    @RequestMapping(value = {"/addNewTrainByParameters"}, method = RequestMethod.GET)
    public String addNewTrainByParameters(@ModelAttribute("train") Train train) {

        trainService.saveTrain(train);
        return RequestType.REDIRECT + "trains";
    }

    @RequestMapping(value = {"/newTrain"}, method = RequestMethod.GET)
    public ModelAndView addNewTrain() {
        return new ModelAndView("newTrain","train",new Train());
    }

}
