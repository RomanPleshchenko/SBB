package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.Passenger;

import java.util.List;

/**
 * Created by РОМАН on 09.04.2017.
 */
public interface PassengerDao {

    Passenger findById(Integer id);

    List<Passenger> findAll();
}
