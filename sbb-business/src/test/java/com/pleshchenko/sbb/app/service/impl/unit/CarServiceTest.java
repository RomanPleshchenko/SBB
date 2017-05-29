package com.pleshchenko.sbb.app.service.impl.unit;

import com.pleshchenko.sbb.app.entity.ticket.Car;
import com.pleshchenko.sbb.app.repositories.interfaces.CarDao;
import com.pleshchenko.sbb.app.service.impl.CarServiceImpl;
import com.pleshchenko.sbb.app.service.interfaces.CarService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by РОМАН on 28.05.2017.
 */
public class CarServiceTest {

    private CarServiceImpl carService;
    private Car car;
    private int carId;

    @Before
    public void setUp() throws Exception {

        carId = 1;
        car = new Car();
        car.setId(carId);

    }

    @Test
    public void findById(){
        Mockery context = new Mockery();
        final CarDao mockCarDao = context.mock(CarDao.class);

        carService = new CarServiceImpl(mockCarDao);

        context.checking(new Expectations(){{
            oneOf(mockCarDao).findById(carId);
            will(returnValue(findById(carId)));
        }});

        Car car = carService.findById(carId);

        Assert.assertTrue(car!=null);
        Assert.assertEquals(car.getId(), carId);

        context.assertIsSatisfied();

    }

    // imitating DB query
    public Car findById(int carId) {

        if (car.getId()==carId){
            return car;
        }
        return null;
    }

}
