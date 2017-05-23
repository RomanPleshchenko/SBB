package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.TrainComposition;

import java.util.List;

/**
 * Created by РОМАН on 23.05.2017.
 */
public interface TrainCompositionDao {

    List<TrainComposition> findAll();

    void deleteTrainComposition(TrainComposition trainComposition);
}
