package com.pleshchenko.sbb.service.repositories.interfaces;

import com.pleshchenko.sbb.model.entity.Train;

import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
public interface TrainDao {

    List<Train> findAll();

    void deleteByNumber(String number);

    void saveTrain(Train train);

    Train findByNumber(String name);

    Train findById(Integer id);

}
