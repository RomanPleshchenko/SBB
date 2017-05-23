package com.pleshchenko.sbb.app.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pleshchenko.sbb.app.converter.CarsListToArray;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.ticket.Car;
import com.pleshchenko.sbb.app.entity.ticket.Train;
import com.pleshchenko.sbb.app.entity.ticket.TrainComposition;
import com.pleshchenko.sbb.app.repositories.interfaces.TrainDao;
import com.pleshchenko.sbb.app.service.interfaces.CarService;
import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
import com.pleshchenko.sbb.app.service.interfaces.TrainCompositionService;
import com.pleshchenko.sbb.app.service.interfaces.TrainService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Service("trainService")
@Transactional
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao dao;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    CarService carService;

    @Autowired
    TrainCompositionService trainCompositionService;

    @Override
    public List<Train> findAll() {

        List<Train> trains = dao.findAll();
        return trains;
    }

    @Override
    public void deleteByNumber(String number) {
        dao.deleteByNumber(number);
    }

    @Override
    public void saveTrain(Train train) {
        dao.saveTrain(train);
    }

    @Override
    public Train findByNumber(String number) {
        Train train = dao.findByNumber(number);
        return train;
    }

    @Override
    public Train findById(Integer id) {
        Train train = dao.findById(id);
        return train;
    }

    @Override
    public String getTrainsCompositionJSONByTrainId(int trainId) {

        Train train = findById(trainId);
        Set<Car> cars = train.getCars();

        String response = CarsListToArray.convertListToJsonString(new ArrayList<>(cars));
        return response;
    }

    @Override
    public boolean trainIsEditable(int trainId) {

        List<Schedule> schedules = scheduleService.findByTrainId(trainId);
        for (Schedule schedule:schedules) {

            if (schedule.isComposed()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void updateTrainFromJSON(String jsonString) {

        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray = (JSONArray)jsonObject.get("carArray");
        int trainId = Integer.parseInt((String)jsonObject.get("trainId"));

        Train train = dao.findById(trainId);

        for (TrainComposition trainComposition:train.getTrainCompositions()) {
            trainCompositionService.deleteTrainComposition(trainComposition);
        }

        train.getTrainCompositions().clear();

        for (Object jsonpObject:jsonArray) {

            int carId = Integer.parseInt((String)((JSONObject)jsonpObject).get("carId"));
            Car car = carService.findById(carId);

            TrainComposition trainComposition = new TrainComposition();
            trainComposition.setCar(car);
            trainComposition.setTrain(train);

            train.getTrainCompositions().add(trainComposition);
        }

        dao.saveTrain(train);
    }
}
