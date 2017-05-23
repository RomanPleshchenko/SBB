package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.CarPrototype;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
public interface CarPrototypeDao {

    List<CarPrototype> findAll();

    CarPrototype findByCarClassId(int id);
}
