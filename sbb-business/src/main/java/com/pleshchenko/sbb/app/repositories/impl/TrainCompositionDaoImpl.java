package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.ticket.TrainComposition;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.TrainCompositionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 23.05.2017.
 */
@Repository("trainComposition")
public class TrainCompositionDaoImpl extends AbstractDao<Integer,TrainComposition> implements TrainCompositionDao {
    @Override
    public List<TrainComposition> findAll() {
        List<TrainComposition> trainCompositions = getEntityManager()
                .createQuery("SELECT t FROM TrainComposition t")
                .getResultList();
        return trainCompositions;
    }

    @Override
    public void deleteTrainComposition(TrainComposition trainComposition) {
        delete(trainComposition);
    }
}
