package com.pleshchenko.sbb.service.dto.impl;

import com.pleshchenko.sbb.model.entity.Passenger;
import com.pleshchenko.sbb.service.dao.interfaces.PassengerDao;
import com.pleshchenko.sbb.service.dto.interfaces.PassengerService;
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
    public List<Passenger> findAll() {
        List<Passenger> passenger =  dao.findAll();
        return passenger;
    }
}
