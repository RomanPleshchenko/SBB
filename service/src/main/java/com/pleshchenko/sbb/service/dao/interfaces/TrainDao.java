package com.pleshchenko.sbb.service.dao.interfaces;

import com.pleshchenko.sbb.model.model.entity.Train;

import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
public interface TrainDao {

    List<Train> findAll();

}
