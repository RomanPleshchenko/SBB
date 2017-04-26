package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.ticket.CarPrototypeComposition;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.CarPrototypeCompositionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Repository("CarPrototypeCompositionDao")
public class CarPrototypeCompositionDaoImpl extends AbstractDao<Integer,CarPrototypeComposition> implements CarPrototypeCompositionDao {
    @Override
    public List<CarPrototypeComposition> findAll() {
        List<CarPrototypeComposition> carPrototypeCompositions = getEntityManager()
                .createQuery("SELECT c FROM CarPrototypeComposition c")
                .getResultList();
        return carPrototypeCompositions;
    }
}
