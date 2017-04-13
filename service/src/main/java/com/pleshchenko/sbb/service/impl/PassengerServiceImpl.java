package com.pleshchenko.sbb.service.impl;

import com.pleshchenko.sbb.model.entity.Passenger;
import com.pleshchenko.sbb.repositories.interfaces.PassengerDao;
import com.pleshchenko.sbb.service.interfaces.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 09.04.2017.
 */
@Service("passengerService")
@Transactional
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerDao dao;

    @Override
    public Passenger findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Passenger> findAll() {
        List<Passenger> passenger =  dao.findAll();
        return passenger;
    }
}
