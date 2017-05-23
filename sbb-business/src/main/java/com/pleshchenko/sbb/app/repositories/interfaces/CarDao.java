package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.Car;

import java.util.List;

/**
 * Created by РОМАН on 23.05.2017.
 */
public interface CarDao {

    List<Car> findAll();

    Car findById(int carId);

    void deleteById(int id);

    void save(Car car);
}
