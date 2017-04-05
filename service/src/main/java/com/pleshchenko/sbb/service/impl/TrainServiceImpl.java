package com.pleshchenko.sbb.service.impl;

import com.pleshchenko.sbb.model.model.entity.Train;
import com.pleshchenko.sbb.service.dao.interfaces.TrainDao;
import com.pleshchenko.sbb.service.dao.interfaces.UserDao;
import com.pleshchenko.sbb.service.interfaces.TrainService;
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
}
