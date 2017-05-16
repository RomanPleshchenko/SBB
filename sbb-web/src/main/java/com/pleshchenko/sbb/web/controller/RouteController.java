package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.service.interfaces.RouteService;
import com.pleshchenko.sbb.web.AjaxResponseBody;
import com.pleshchenko.sbb.web.SearchCriteria;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/sendRouteCompositionsJSON",method = RequestMethod.POST)
    public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {


        String jsonString = search.getAllJSON();
        routeService.updateRouteFromJSON(jsonString);

        AjaxResponseBody result = new AjaxResponseBody();
        result.setMsg("ok");
        result.setCode("204");

        return null;

    }

}
