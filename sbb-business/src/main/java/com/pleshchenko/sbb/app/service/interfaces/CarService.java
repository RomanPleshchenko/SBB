package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by РОМАН on 23.05.2017.
 */
@Service("carService")
@Transactional
public interface CarService {

    /**
     *
     * @return list of all cars in JSON
     */
    String getAllCarsJSON();

    /**
     *
     * @param carId
     * @return
     */
    Car findById(int carId);

    /**
     * deleted car by id
     * @param id
     */
    void deleteById(int id);

    /**
     *
     * @param car
     */
    void save(Car car);
}
