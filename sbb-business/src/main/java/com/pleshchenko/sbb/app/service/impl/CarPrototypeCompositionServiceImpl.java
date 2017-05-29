package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.CarPrototypeComposition;
import com.pleshchenko.sbb.app.repositories.interfaces.CarPrototypeCompositionDao;
import com.pleshchenko.sbb.app.service.interfaces.CarPrototypeCompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("carPrototypeCompositionService")
@Transactional
public class CarPrototypeCompositionServiceImpl implements CarPrototypeCompositionService {

    @Autowired
    CarPrototypeCompositionDao dao;

    public CarPrototypeCompositionServiceImpl() {
    }

    public CarPrototypeCompositionServiceImpl(CarPrototypeCompositionDao dao) {
        this.dao = dao;
    }

    @Override
    public List<CarPrototypeComposition> findAll() {
        List<CarPrototypeComposition> carPrototypeCompositions = dao.findAll();
        return carPrototypeCompositions;
    }
}
