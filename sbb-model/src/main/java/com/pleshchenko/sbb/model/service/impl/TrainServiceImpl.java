package com.pleshchenko.sbb.model.service.impl;

import com.pleshchenko.sbb.model.entity.Train;
import com.pleshchenko.sbb.model.repositories.interfaces.TrainDao;
import com.pleshchenko.sbb.model.service.interfaces.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Service("trainService")
@Transactional
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao dao;

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
}
