package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.converter.CarsListToArray;
import com.pleshchenko.sbb.app.entity.ticket.Car;
import com.pleshchenko.sbb.app.exception.RepeatingFieldsException;
import com.pleshchenko.sbb.app.repositories.interfaces.CarDao;
import com.pleshchenko.sbb.app.service.interfaces.CarPrototypeService;
import com.pleshchenko.sbb.app.service.interfaces.CarService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 23.05.2017.
 */
@Service("CarService")
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao dao;

    @Autowired
    CarPrototypeService carPrototypeService;

    @Autowired
    CarService carService;

    public CarServiceImpl() {
    }

    public CarServiceImpl(CarDao dao) {
        this.dao = dao;
    }

    @Override
    public String getAllCarsJSON() {

        List<Car> cars = dao.findAll();
        String response = CarsListToArray.convertListToJsonString(cars);
        return response;
    }

    @Override
    public Car findById(int carId) {
        Car car = dao.findById(carId);
        return car;
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Car car) {
        dao.save(car);
    }

    @Override
    public void findByNumber(int carsNumber) {
        Car car = dao.findByNumber(carsNumber);
    }

    @Override
    public void save(String carJSON) throws RepeatingFieldsException {
        JSONObject jsonObject = new JSONObject(carJSON);
        int carsNumber = Integer.parseInt((String)jsonObject.get("carsNumber"));
        int carsClassId = Integer.parseInt((String)jsonObject.get("carsClassId"));

        Car  existingCar = dao.findByNumber(carsNumber);
        if (existingCar!=null){
            throw new RepeatingFieldsException("Existing a car: with number: " + carsNumber);
        }

        Car car = new Car(carPrototypeService.findByCarClassId(carsClassId),carsNumber);
        carService.save(car);

    }

}
