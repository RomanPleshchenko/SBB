package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.ticket.Car;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.CarDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 23.05.2017.
 */
@Repository("CarDao")
public class CarDaoImpl  extends AbstractDao<Integer,Car> implements CarDao {
    @Override
    public List<Car> findAll() {
        List<Car> cars = getEntityManager()
                .createQuery("SELECT c FROM Car c")
                .getResultList();
        return cars;
    }

    @Override
    public Car findById(int carId){

        Car car = (Car)getEntityManager()
                .createQuery("SELECT c FROM Car c WHERE c.id = :carId")
                .setParameter("carId",carId)
                .getSingleResult();
        return car;
    }

    @Override
    public void deleteById(int id){
        delete(findById(id));
    }

    @Override
    public void save(Car car){
        persist(car);
    }
}
