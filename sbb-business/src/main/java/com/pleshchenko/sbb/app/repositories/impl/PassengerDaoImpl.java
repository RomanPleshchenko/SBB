package com.pleshchenko.sbb.app.repositories.impl;


import com.pleshchenko.sbb.app.entity.ticket.Passenger;
import com.pleshchenko.sbb.app.repositories.interfaces.PassengerDao;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 09.04.2017.
 */
@Repository("passengerDao")
public class PassengerDaoImpl extends AbstractDao<Integer,Passenger> implements PassengerDao {
    @Override
    public Passenger findById(Integer id) {
        return getByKey(id);
    }

    @Override
    public List<Passenger> findAll() {
        List<Passenger> stations = getEntityManager()
                .createQuery("SELECT p FROM Passenger p ORDER BY p.name ASC")
                .getResultList();
        return stations;
    }
}
