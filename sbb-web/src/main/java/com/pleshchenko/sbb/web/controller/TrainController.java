package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.ticket.Train;
import com.pleshchenko.sbb.app.service.interfaces.TrainService;
import com.pleshchenko.sbb.web.SearchCriteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Controller
@RequestMapping("/")
public class TrainController {

    static final Logger logger = LogManager.getLogger(TrainController.class);

    @Autowired
    TrainService trainService;

    @RequestMapping(value = "/trains",method = RequestMethod.GET)
    public String goTrainslist(ModelMap model){

        List<Train> trains  = trainService.findAll();
        model.addAttribute("trains", trains);
        return "trainslist";
    }

    @RequestMapping(value = {"/newTrain"}, method = RequestMethod.GET)
    public String addNewTrain() {
        return "newTrain";
    }

    @RequestMapping(value = "/saveTrain",method = RequestMethod.POST)
    public ResponseEntity<?> saveTrain(@RequestBody SearchCriteria search) {

        String trainsNumber = search.getText();

        if (trainsNumber==null||trainsNumber.equals("")){
            return ResponseEntity.ok("trains number is empty");
        }

        if (trainService.findByNumber(trainsNumber)!=null){
            return ResponseEntity.ok("Train number '" + trainsNumber + "' already exists");
        }

        try{
            trainService.saveTrain(new Train(trainsNumber));
            return ResponseEntity.ok("Train saved");
        }catch (Exception e){
            logger.error("Train is not saved:" + e.getMessage());
            return ResponseEntity.ok("Train is not saved");
        }
    }

    @RequestMapping(value = "/getTrainsCompositionJSONByTrainId", method = RequestMethod.GET)
    public @ResponseBody String getTrainsCompositionJSONByTrainId(@RequestParam("trainId") int trainId) throws JSONException {

        String jsonResponse = trainService.getTrainsCompositionJSONByTrainId(trainId);
        return jsonResponse;

    }

    @RequestMapping(value = "/trainIsEditable", method = RequestMethod.GET)
    public @ResponseBody boolean trainIsEditable(@RequestParam("trainId") int trainId) throws JSONException {

        boolean routeIsEditable = trainService.trainIsEditable(trainId);
        return routeIsEditable;

    }

    @RequestMapping(value = "/sendTrainCompositionsJSON",method = RequestMethod.POST)
    public ResponseEntity<?> sendTrainCompositionsJSON(@RequestBody SearchCriteria search) {

        String jsonString = search.getText();

        trainService.updateTrainFromJSON(jsonString);

        return ResponseEntity.ok("OK");

    }

    @RequestMapping(value = {"/deleteTrainByNumber"}, method = RequestMethod.POST)
    public  ResponseEntity<?> deleteTrainByNumber(@RequestBody SearchCriteria search) {

        String trainsNumber = search.getText();
        try {
            trainService.deleteByNumber(trainsNumber);
            return ResponseEntity.ok("Train deleted");
        }catch (Exception e){

            logger.error("Unsuccessful attempt to delete a train:" + trainsNumber);
            logger.error(e.getMessage());
            return ResponseEntity.ok("You cannot delete this train!!!");
        }

    }

}
