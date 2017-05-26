package com.pleshchenko.sbb.web.rest;

import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by РОМАН on 25.05.2017.
 */
@Controller
@RequestMapping("/")
public class RestController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/getScheduleJSONByStationsName", method = RequestMethod.GET)
    public @ResponseBody
    String getScheduleJSONByStationsName(@RequestParam("stationsName") String stationsName) throws JSONException {

        String scheduleJSON = scheduleService.getScheduleJSONByStationsName(stationsName);
        return scheduleJSON;
    }

    @RequestMapping(value = "/getScheduleJSONByStationsNameAndID", method = RequestMethod.GET)
    public @ResponseBody String getScheduleJSONByID(@RequestParam("id") int id,@RequestParam("stationsName") String stationsName) throws JSONException {

        String scheduleJSON = scheduleService.getScheduleJSONByStationsNameAndID(id,stationsName);
        return scheduleJSON;
    }

}
