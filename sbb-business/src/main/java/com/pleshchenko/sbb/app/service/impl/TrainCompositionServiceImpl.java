package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.TrainComposition;
import com.pleshchenko.sbb.app.repositories.interfaces.TrainCompositionDao;
import com.pleshchenko.sbb.app.service.interfaces.TrainCompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 23.05.2017.
 */
@Service("trainCompositionService")
@Transactional
public class TrainCompositionServiceImpl implements TrainCompositionService {

    @Autowired
    TrainCompositionDao dao;

    @Override
    public List<TrainComposition> findAll() {
        List<TrainComposition> trainCompositions = dao.findAll();
        return trainCompositions;
    }

    @Override
    public void deleteTrainComposition(TrainComposition trainComposition) {
        dao.deleteTrainComposition(trainComposition);
    }
}
