package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.ticket.Passenger;
import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.ticket.TripsSite;
import com.pleshchenko.sbb.app.service.interfaces.PassengerService;
import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
import com.pleshchenko.sbb.app.service.interfaces.TicketService;
import com.pleshchenko.sbb.app.service.other.SetId;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
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

    @RequestMapping(value = "/tickets",method = RequestMethod.GET)
    public String goTicketsLis(ModelMap model){
        List<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets",tickets);
        return "ticketslist";
    }


    @RequestMapping(value = { "/getFreeTicket" }, method = RequestMethod.GET)
    public @ResponseBody String getFreeTicket(@RequestParam("st1") int st1, @RequestParam("st2") int st2,
                               @RequestParam("dirId") int dirId,@RequestParam("routeId") int routeId, ModelMap model) {


        //?????? перенести в сервисы
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


    @RequestMapping(value = "/buyTicket", method = RequestMethod.GET)
    public String showData(@RequestParam("st1") int st1, @RequestParam("st2") int st2,
                                         @RequestParam("dirId") int dirId,@RequestParam("carId") int carId,
                           @RequestParam("siteId") int siteId,@RequestParam("userName") String userName, Model model) throws JSONException {


        //qqqqqqqqqq
        model.addAttribute("st1",st1);
        model.addAttribute("st2",st2);
        model.addAttribute("dirId",dirId);
        model.addAttribute("carId",carId);
        model.addAttribute("siteId",siteId);
        model.addAttribute("userName",userName);
        //qqqqqqqqqq

        ticketService.buyTicket(st1,st2,dirId,carId,siteId,userName);

        return "ticketSucces";
    }



}
