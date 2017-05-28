package com.pleshchenko.sbb.web.controller;

import com.pleshchenko.sbb.app.entity.schedule.Route;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.ticket.Train;
import com.pleshchenko.sbb.app.service.interfaces.*;
import com.pleshchenko.sbb.web.SearchCriteria;
import com.pleshchenko.sbb.web.messaging.MessageSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.time.Instant;
import java.util.List;


/**
 * Created by РОМАН on 05.04.2017.
 */
@Controller
@RequestMapping("/")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

    @Autowired
    RouteService routeService;

    @Autowired
    MessageSender messageSender;

    static final Logger logger = LogManager.getLogger(TrainController.class);

    @RequestMapping(value = "/schedule",method = RequestMethod.GET)
    public String getSchedule(ModelMap model){

        List<Schedule> schedule = scheduleService.findAll();
        List<Route> routes = routeService.findAll();
        List<Train> trains = trainService.findAll();

        model.addAttribute("schedule",schedule);
        model.addAttribute("routes",routes);
        model.addAttribute("trains",trains);
        return "schedule";
    }

    @RequestMapping(value = "/addToSchedule",method = RequestMethod.GET)
    public String addToSchedule(ModelMap model){

        return "addToSchedule";
    }

    @RequestMapping(value = { "/make-active-dir-{id}" }, method = RequestMethod.GET)
    public String makeActive(@PathVariable int id, ModelMap model) {

        messageSender.sendMessage("update",id);
        scheduleService.makeActive(id);
        return RequestType.REDIRECT + "schedule";
    }

    @RequestMapping(value = { "/make-not-active-dir-{id}" }, method = RequestMethod.GET)
    public String makeNotActive(@PathVariable int id, ModelMap model) {

        messageSender.sendMessage("remove",id);
        scheduleService.makeNotActive(id);
        return RequestType.REDIRECT + "schedule";
    }

    @RequestMapping(value = {"/composeFreeSitesByScheduleId"}, method = RequestMethod.POST)
    public  ResponseEntity<?> composeFreeSitesByScheduleId(@RequestBody SearchCriteria search) {

        int scheduleId = Integer.parseInt(search.getText());
        try {
            scheduleService.composeFreeSites(scheduleId);
            return ResponseEntity.ok("Sites composed");
        }catch (Exception e){
            logger.error("Unsuccessful attempt composed schedule: " + scheduleId);
            logger.error(e.getMessage());
            return ResponseEntity.ok("");
        }
    }

    @RequestMapping(value = "/getScheduleJSON", method = RequestMethod.GET)
    public @ResponseBody String showData(@RequestParam("st1") int st1, @RequestParam("st2") int st2,
                                         @RequestParam("date1") String date1,@RequestParam("date2") String date2, Model model) throws JSONException {

        Date dat1 = Date.valueOf(date1);
        Date dat2 = Date.valueOf(date2);

        String scheduleJSON = scheduleService.getScheduleJSONByParameters(st1,st2,dat1,dat2);
        return scheduleJSON;
    }

    @RequestMapping(value = "/routeIsEditable", method = RequestMethod.GET)
    public @ResponseBody boolean routeIsEditable(@RequestParam("routeId") int routeId) throws JSONException {


        boolean routeIsEditable = scheduleService.routeIsEditable(routeId);
        return routeIsEditable;
    }

    @RequestMapping(value = {"/saveNewSchedule"}, method = RequestMethod.POST)
    public ResponseEntity<?> saveNewSchedule(@RequestBody SearchCriteria search) {

        String json = search.getText();

        JSONObject jsonObject = new JSONObject(json);
        int routeId = Integer.parseInt((String)jsonObject.get("routeId"));
        int trainId = Integer.parseInt((String)jsonObject.get("trainId"));
        String departureTimeString = (String)jsonObject.get("departureTime");

        Instant departureTime = Instant.parse(departureTimeString).plusSeconds(-3600*3);

        try{
            Route route = routeService.findById(routeId);
            Train train = trainService.findById(trainId);

            Schedule schedule = new Schedule(route,train,departureTime);
            scheduleService.save(schedule);

            return ResponseEntity.ok("Schedule saved");
        }catch (Exception e){
            System.out.println(e.getMessage());
            logger.error("Schedule is not saved:" + e.getMessage());
            return ResponseEntity.ok("Schedule is not saved");
        }

    }


}


