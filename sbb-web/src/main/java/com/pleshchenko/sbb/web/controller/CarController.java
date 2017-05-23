package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.service.interfaces.CarService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by РОМАН on 23.05.2017.
 */
@Controller
@RequestMapping("/")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/getAllCarsJSON", method = RequestMethod.GET)
    public @ResponseBody
    String getAllCarsJSON() throws JSONException {

        String jsonResponse = carService.getAllCarsJSON();
        return jsonResponse;

    }

}
