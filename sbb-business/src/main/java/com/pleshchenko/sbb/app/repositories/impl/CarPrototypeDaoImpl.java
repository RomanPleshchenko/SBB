package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.ticket.CarPrototype;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.CarPrototypeDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Repository("carPrototypeDao")
public class CarPrototypeDaoImpl extends AbstractDao<Integer,CarPrototype> implements CarPrototypeDao {
    @Override
    public List<CarPrototype> findAll() {
        List<CarPrototype> carPrototypes = getEntityManager()
                .createQuery("SELECT c FROM CarPrototype c")
                .getResultList();
        return carPrototypes;
    }
}
