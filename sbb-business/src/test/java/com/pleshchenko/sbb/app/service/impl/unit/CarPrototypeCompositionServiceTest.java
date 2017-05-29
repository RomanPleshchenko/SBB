package com.pleshchenko.sbb.app.service.impl.unit;

import com.pleshchenko.sbb.app.entity.ticket.CarPrototypeComposition;
import com.pleshchenko.sbb.app.repositories.interfaces.CarPrototypeCompositionDao;
import com.pleshchenko.sbb.app.service.impl.CarPrototypeCompositionServiceImpl;
import com.pleshchenko.sbb.app.service.interfaces.CarPrototypeCompositionService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by РОМАН on 29.05.2017.
 */
public class CarPrototypeCompositionServiceTest {

    private List<CarPrototypeComposition> carPrototypeCompositionList;

    @Before
    public void setUp() {

        carPrototypeCompositionList = new ArrayList<>();
        carPrototypeCompositionList.add(new CarPrototypeComposition());
        carPrototypeCompositionList.add(new CarPrototypeComposition());
        carPrototypeCompositionList.add(new CarPrototypeComposition());
        carPrototypeCompositionList.add(new CarPrototypeComposition());
    }

    @Test
    public void getStationsList() {

        Mockery context = new Mockery();
        final CarPrototypeCompositionDao mockDao = context.mock(CarPrototypeCompositionDao.class);

        CarPrototypeCompositionService carPrototypeCompositionService = new CarPrototypeCompositionServiceImpl(mockDao);

        context.checking(new Expectations() {{
            oneOf(mockDao).findAll();
            will(returnValue(carPrototypeCompositionList));
        }});

        List<CarPrototypeComposition> carPrototypeCompositions = carPrototypeCompositionService.findAll();
        Assert.assertTrue(carPrototypeCompositions.size()==carPrototypeCompositionList.size());
        Assert.assertNotEquals(carPrototypeCompositions.size(),0);
        context.assertIsSatisfied();

    }

}
