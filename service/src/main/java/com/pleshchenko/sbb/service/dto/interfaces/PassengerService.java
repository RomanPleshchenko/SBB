package com.pleshchenko.sbb.service.dto.interfaces;

import com.pleshchenko.sbb.model.entity.Passenger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 09.04.2017.
 */
@Service("passengerService")
@Transactional
public interface PassengerService {
    List<Passenger> findAll();
}
