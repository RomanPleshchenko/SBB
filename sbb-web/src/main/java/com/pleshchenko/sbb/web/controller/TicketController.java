package com.pleshchenko.sbb.web.controller;


import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.exception.RepeatingFieldsException;
import com.pleshchenko.sbb.app.service.interfaces.*;
import com.pleshchenko.sbb.web.SearchCriteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Controller
@RequestMapping("/")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    TrainService trainService;

    static final Logger logger = LogManager.getLogger(TrainController.class);

    @RequestMapping(value = "/tickets",method = RequestMethod.GET)
    public String goTicketsLis(ModelMap model){

        model.addAttribute("trains", trainService.findAll());
        return "ticketslist";
    }

    @RequestMapping(value = "/myTickets",method = RequestMethod.GET)
    public String goMyTicketsLis(){
        return "usersTicketslist";
    }


    @RequestMapping(value = { "/getFreeTicket" }, method = RequestMethod.GET)
    public @ResponseBody String getFreeTicket(@RequestParam("st1") int st1, @RequestParam("st2") int st2,
                               @RequestParam("dirId") int dirId,@RequestParam("routeId") int routeId, ModelMap model) {


        //qqqqqqqqq перенести в сервисы
        List freeSites = scheduleService.findFreeSite(st1,st2,dirId,routeId);

        Map<Integer,String> svgFileNameMap = new HashMap();
        Map<Integer,List<Integer>> mapFreeSite = new HashMap<>();

        for (Object el:freeSites) {

            int carId = (int)((Object[])el)[0];
            String svgFileName = (String)((Object[])el)[1];
            int siteNumber = (int)((Object[])el)[2];

            if(!svgFileNameMap.containsKey(carId)){
                svgFileNameMap.put(carId,svgFileName);
            }

            if(!mapFreeSite.containsKey(carId)){
                List<Integer> list = new ArrayList<Integer>();
                list.add(siteNumber);
                mapFreeSite.put(carId,list);
            }else {
                mapFreeSite.get(carId).add(siteNumber);
            }
        }


        JSONArray jsonArray = new JSONArray();

        for (Map.Entry<Integer,List<Integer>> entry:mapFreeSite.entrySet()){

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("carNumber",entry.getKey());
            jsonObject.put("carSvgFileName",svgFileNameMap.get(entry.getKey()));

            JSONArray freeSitesArray = new JSONArray();
            for (int num:entry.getValue()){
                freeSitesArray.put(num);
            }
            jsonObject.put("freeSitesArray",freeSitesArray);
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }


    @RequestMapping(value = {"/buyTicket"}, method = RequestMethod.POST)
    public ResponseEntity<?> buyTicket(@RequestBody SearchCriteria search) {

        String json = search.getText();

        try{
            Ticket ticket = ticketService.buyTicket(json);
            return ResponseEntity.ok("Ticket purchased");
        } catch (RepeatingFieldsException e) {
            logger.error("Ticket is not purchased:" + e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        }catch (Exception e){
            logger.error("Ticket is not purchased:" + e.getMessage());
            return ResponseEntity.ok("");
        }


    }


    @RequestMapping(value = "/getTicketsJSONByTrainId", method = RequestMethod.GET)
    public @ResponseBody String getTicketsJSONByTrainId(@RequestParam("trainId") int trainId) throws JSONException {

        return ticketService.getTicketsJSONByTrainId(trainId);

    }

    @RequestMapping(value = "/getTicketsJSONByUserSSO", method = RequestMethod.GET)
    public @ResponseBody String getTicketsJSONByUserSSO(@RequestParam("userSSO") String userSSO) throws JSONException {

        return ticketService.getTicketsJSONByUserSSO(userSSO);

    }

}
