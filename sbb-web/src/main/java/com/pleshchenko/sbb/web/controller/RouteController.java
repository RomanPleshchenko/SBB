package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.service.interfaces.RouteService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by РОМАН on 15.05.2017.
 */
@Controller
@RequestMapping("/")
public class RouteController {

    @Autowired
    RouteService routeService;


    @RequestMapping(value = "/routesPage",method = RequestMethod.GET)
    public String goTicketsLis(){

        return "routesList";
    }


    @RequestMapping(value = "/getRoutesJSON", method = RequestMethod.GET)
    public @ResponseBody
    String getRoutesJSON() throws JSONException {

        String routesJSON = routeService.getRoutesJSON();
        return routesJSON;
    }


    @RequestMapping(value = "/getRoutesCompositionJSONByRouteId", method = RequestMethod.GET)
    public @ResponseBody String getRoutesCompositionJSONByRouteId(@RequestParam("routeId") int routeId) throws JSONException {

        String routesJSON = routeService.getRoutesJSONByRouteId(routeId);
        return routesJSON;
    }




}
