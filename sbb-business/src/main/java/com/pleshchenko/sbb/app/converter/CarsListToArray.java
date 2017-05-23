package com.pleshchenko.sbb.app.converter;

import com.pleshchenko.sbb.app.entity.ticket.Car;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by РОМАН on 23.05.2017.
 */
public class CarsListToArray {

    public static String convertListToJsonString(List<Car> cars){

        JSONArray jsonArray = new JSONArray();
        for (Car car:cars){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("car",car.toString());
            jsonObject.put("number",car.getNumber());
            jsonObject.put("carId",car.getId());
            jsonObject.put("carsClass",car.getCarPrototype().getSiteCarClass().getName());
            jsonObject.put("capacity",car.getCarPrototype().getSitePrototypes().size());
            jsonArray.put(jsonObject);
        }

        try {
            String json = jsonArray.toString();
            return json;
        } catch (Exception e) {

            e.printStackTrace();
            return "";
        }
    }
}
