package com.pleshchenko.sbb.service.repositories.impl;

import com.pleshchenko.sbb.model.entity.Train;
import com.pleshchenko.sbb.service.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.repositories.interfaces.TrainDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Repository("trainDao")
public class TrainDaoImpl extends AbstractDao<Integer,Train> implements TrainDao{

    @Override
    public List<Train> findAll() {
        List<Train> trains = getEntityManager()
                .createQuery("SELECT t FROM Train t ORDER BY t.number ASC")
                .getResultList();
        return trains;
    }

    @Override
    public void deleteByNumber(String number) {
        Train train = (Train) getEntityManager()
                .createQuery("SELECT t FROM Train t WHERE t.number LIKE :number")
                .setParameter("number", number)
                .getSingleResult();
        delete(train);
    }

    @Override
    public void saveTrain(Train train) {
        persist(train);
    }

    @Override
    public Train findByNumber(String number) {
        Query query = getEntityManager()
                .createQuery("SELECT t FROM Train t " +
                        "WHERE t.number = :number ");
        query.setParameter("number",number);

        List<Train> trains = query.getResultList();
        if (trains.size()==0){
            return null;
        }else {
            return trains.get(0);
        }
    }

    @Override
    public Train findById(Integer id) {

        Train train = getByKey(id);
        return train;
    }
}
