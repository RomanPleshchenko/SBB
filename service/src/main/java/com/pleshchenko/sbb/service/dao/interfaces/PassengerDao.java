package com.pleshchenko.sbb.service.dao.interfaces;

import com.pleshchenko.sbb.model.entity.Passenger;

import java.util.List;

/**
 * Created by РОМАН on 09.04.2017.
 */
public interface PassengerDao {
    List<Passenger> findAll();
}
