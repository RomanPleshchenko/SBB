package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.schedule.Route;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.entity.ticket.Car;
import com.pleshchenko.sbb.app.entity.ticket.SiteCarClass;
import com.pleshchenko.sbb.app.service.interfaces.CarPrototypeService;
import com.pleshchenko.sbb.app.service.interfaces.CarService;
import com.pleshchenko.sbb.app.service.interfaces.SiteCarClassService;
import com.pleshchenko.sbb.web.SearchCriteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by РОМАН on 23.05.2017.
 */
@Controller
@RequestMapping("/")
public class CarController {

    @Autowired
    SiteCarClassService siteCarClassService;

    @Autowired
    CarPrototypeService carPrototypeService;

    @Autowired
    CarService carService;

    static final Logger logger = LogManager.getLogger(TrainController.class);

    @RequestMapping(value = "/getAllCarsJSON", method = RequestMethod.GET)
    public @ResponseBody
    String getAllCarsJSON() throws JSONException {

        String jsonResponse = carService.getAllCarsJSON();
        return jsonResponse;

    }

    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public String goCars(ModelMap model){

        model.addAttribute("carsClasses",siteCarClassService.findAll());
        return "carslist";
    }

    @RequestMapping(value = "/deleteCarById",method = RequestMethod.POST)
    public ResponseEntity<?> deleteCarById(@RequestBody SearchCriteria search) {

        try {
            int id = Integer.parseInt(((String) search.getText()));
            carService.deleteById(id);
            return ResponseEntity.ok("Car deleted");
        } catch (Exception e) {
            logger.error("Car is not deleted:" + e.getMessage());
            return ResponseEntity.ok("Car is not deleted");
        }
    }

    @RequestMapping(value = {"/saveNewCar"}, method = RequestMethod.POST)
    public  ResponseEntity<?> saveNewCar(@RequestBody SearchCriteria search) {

        String json = search.getText();

        JSONObject jsonObject = new JSONObject(json);
        int carsNumber = Integer.parseInt((String)jsonObject.get("carsNumber"));
        int carsClassId = Integer.parseInt((String)jsonObject.get("carsClassId"));

        try{
            Car car = new Car(carPrototypeService.findByCarClassId(carsClassId),carsNumber);
            carService.save(car);
            return ResponseEntity.ok("Car saved");
        }catch (Exception e){
            System.out.println(e.getMessage());
            logger.error("Car is not saved:" + e.getMessage());
            return ResponseEntity.ok("Car is not saved");
        }

    }

}
