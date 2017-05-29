package com.pleshchenko.sbb.app.service.impl.unit;

import com.pleshchenko.sbb.app.entity.schedule.Route;
import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.entity.schedule.Segment;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.exception.IncorrectRouteCompositionException;
import com.pleshchenko.sbb.app.repositories.interfaces.RouteDao;
import com.pleshchenko.sbb.app.repositories.interfaces.SegmentDao;
import com.pleshchenko.sbb.app.service.impl.RouteServiceImpl;
import com.pleshchenko.sbb.app.service.impl.SegmentServiceImpl;
import com.pleshchenko.sbb.app.service.interfaces.RouteService;
import com.pleshchenko.sbb.app.service.interfaces.SegmentService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by РОМАН on 29.05.2017.
 */
public class RouteServiceTest {

    private List<Route> routeList;
    private int routeId;
    private Route routeById;

    @Before
    public void setUp() {

        routeId = 777;
        routeById = new Route("testNumber","testName");
        routeById.setId(routeId);

        Set<RouteComposition> routeCompositions = new HashSet<>();
        RouteComposition routeComposition = new RouteComposition();
        routeComposition.setDestinationTime(0);
        routeComposition.setDepartureTime(0);
        routeComposition.setSegment(new Segment(new Station("A"),new Station("A")));
        routeCompositions.add(routeComposition);
        routeById.setRouteCompositions(routeCompositions);

        routeList = new ArrayList<>();
        routeList.add(new Route());
        routeList.add(new Route());
        routeList.add(new Route());
        routeList.add(routeById);

    }

    @Test
    public void getRouteList() {

        Mockery context = new Mockery();
        final RouteDao mockDao = context.mock(RouteDao.class);
        RouteService service = new RouteServiceImpl(mockDao);

        context.checking(new Expectations() {{
            oneOf(mockDao).findAll();
            will(returnValue(routeList));
        }});

        List<Route> routes = service.findAll();

        Assert.assertTrue(routes.size()==routeList.size());
        Assert.assertNotEquals(routes.size(),0);

        context.assertIsSatisfied();
    }

    @Test
    public void findById() {

        Mockery context = new Mockery();
        final RouteDao mockDao = context.mock(RouteDao.class);
        RouteService service = new RouteServiceImpl(mockDao);

        context.checking(new Expectations() {{
            oneOf(mockDao).findById(routeId);
            will(returnValue(routeById));
        }});

        Route route = service.findById(routeId);
        Route route2 = new Route();

        Assert.assertEquals(route,routeById);
        Assert.assertNotEquals(route2,routeById);

        context.assertIsSatisfied();
    }

    @Test(expected = IncorrectRouteCompositionException.class)
    public void validateRouteCompositions() throws IncorrectRouteCompositionException {

        Mockery context = new Mockery();
        final RouteDao mockDao = context.mock(RouteDao.class);
        RouteService service = new RouteServiceImpl(mockDao);

        service.validateRouteCompositions(routeById.getRouteCompositions());

    }


}
