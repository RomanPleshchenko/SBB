package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.Passenger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 10.04.2017.
 */
@Service("passengerService")
@Transactional
public interface PassengerService {

    /**
     *
     * @return a passenger by id
     */
    Passenger findById(Integer id);

    /**
     *
     * @return a list of all passenger
     */
    List<Passenger> findAll();
}
