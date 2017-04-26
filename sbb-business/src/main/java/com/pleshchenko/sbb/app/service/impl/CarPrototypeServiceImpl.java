package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.CarPrototype;
import com.pleshchenko.sbb.app.repositories.interfaces.CarPrototypeDao;
import com.pleshchenko.sbb.app.service.interfaces.CarPrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("carPrototypeService")
@Transactional
public class CarPrototypeServiceImpl implements CarPrototypeService {

    @Autowired
    CarPrototypeDao dao;
    @Override
    public List<CarPrototype> findAll() {
        List<CarPrototype> carPrototypes = dao.findAll();
        return carPrototypes;
    }
}
