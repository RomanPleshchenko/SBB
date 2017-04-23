package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.ticket.Train;
import com.pleshchenko.sbb.app.service.interfaces.TrainService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
public class TrainsController {

    static final Logger logger = LogManager.getLogger(TrainsController.class);

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

            logger.error("Unsuccessful attempt to delete a train:" + number);
            logger.error(e.getMessage());

            model.addAttribute("message","You cannot delete this train!!!");
            return "notification";
        }
    }

    @RequestMapping(value = {"/newTrain"}, method = RequestMethod.POST)
    public String addNewTrainByParameters(@Valid @ModelAttribute("train") Train train,BindingResult bindingResult,ModelMap model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error","You must fill in all the fields");
            return "newTrain";
        }

        if (trainService.findByNumber(train.getNumber())!=null){
            model.addAttribute("error","Train number " + train.getNumber() + " already exists");
            return "newTrain";
        }

        trainService.saveTrain(train);
        return RequestType.REDIRECT + "trains";
    }

    @RequestMapping(value = {"/newTrain"}, method = RequestMethod.GET)
    public ModelAndView addNewTrain(ModelMap model) {
        return new ModelAndView("newTrain","train",new Train());
    }

}
