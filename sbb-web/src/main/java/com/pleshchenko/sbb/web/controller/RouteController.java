package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.schedule.Route;
import com.pleshchenko.sbb.app.entity.ticket.Train;
import com.pleshchenko.sbb.app.exception.IncorrectRouteCompositionException;
import com.pleshchenko.sbb.app.service.interfaces.RouteService;
import com.pleshchenko.sbb.web.SearchCriteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by РОМАН on 15.05.2017.
 */
@Controller
@RequestMapping("/")
public class RouteController {

    static final Logger logger = LogManager.getLogger(TrainController.class);

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

    @RequestMapping(value = "/sendRouteCompositionsJSON",method = RequestMethod.POST)
    public ResponseEntity<?> getSearchResultViaAjax(@RequestBody SearchCriteria search) {


        return ResponseEntity.ok("Temporarily disabled, the error in js");

//        String jsonString = search.getText();
//        try {
//            routeService.updateRouteFromJSON(jsonString);
//            return ResponseEntity.ok("OK");
//        } catch (IncorrectRouteCompositionException e) {
//            logger.error(e.getMessage());
//            return ResponseEntity.ok(e.getMessage());
//        }


    }

    @RequestMapping(value = {"/newRoute"}, method = RequestMethod.GET)
    public String addNewRoute() {
        return "newRoute";
    }


    @RequestMapping(value = "/saveRoute",method = RequestMethod.POST)
    public ResponseEntity<?> saveRoute(@RequestBody SearchCriteria search) {

        String json = search.getText();

        JSONObject jsonObject = new JSONObject(json);
        String routesNumber = (String)jsonObject.get("routesNumber");
        String routesName = (String)jsonObject.get("routesName");

        if (routeService.findByNumber(routesNumber)!=null){
            return ResponseEntity.ok("Route number '" + routesNumber + "' already exists");
        }

        try{
            Route route = new Route(routesNumber,routesName);
            routeService.save(route);
            return ResponseEntity.ok("Route saved");
        }catch (Exception e){
            logger.error("Route is not saved:" + e.getMessage());
            return ResponseEntity.ok("Route is not saved");
        }
    }

}
