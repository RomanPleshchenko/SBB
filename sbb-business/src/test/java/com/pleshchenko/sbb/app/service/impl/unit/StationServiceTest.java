package com.pleshchenko.sbb.app.service.impl.unit;

import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.repositories.interfaces.StationDao;
import com.pleshchenko.sbb.app.service.impl.StationServiceImpl;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StationServiceTest {

    private List<Station> stationList;
    private String stationsName;
    private String stationsName2;
    private Station stationByName;
    private int stationsId;

    @Before
    public void setUp() {

        stationsName = "test";
        stationsName2 = "test2";

        stationList = new ArrayList<>();

        for (int i = 1; i < 5; i++){
            stationList.add(new Station("name" + i));
        }

        stationByName = new Station("stationsName");
        stationList.add(stationByName);
    }

    @Test
    public void getStationsList() {

        Mockery context = new Mockery();
        final StationDao mockDao = context.mock(StationDao.class);

        StationService stationService = new StationServiceImpl(mockDao);

        context.checking(new Expectations() {{
            oneOf(mockDao).findAll();
            will(returnValue(stationList));
        }});

        List<Station> stations = stationService.findAll();
        Assert.assertTrue(stations.size()==stationList.size());
        context.assertIsSatisfied();

    }

    @Test
    public void findByName() {

        Mockery context = new Mockery();
        final StationDao mockStationDao = context.mock(StationDao.class);

        StationService stationService = new StationServiceImpl(mockStationDao);

        context.checking(new Expectations() {{
            oneOf(mockStationDao).findByName(stationsName);
            will(returnValue(stationByName));
        }});

        Station station = stationService.findByName(stationsName);
        Station incorectStation = new Station(stationsName + "test");

        Assert.assertEquals(station,stationByName);
        Assert.assertNotEquals(stationByName,incorectStation);
        Assert.assertNotNull(station);

        context.assertIsSatisfied();
    }

    @Test
    public void findById() {

        Mockery context = new Mockery();
        final StationDao mockStationDao = context.mock(StationDao.class);

        StationService stationService = new StationServiceImpl(mockStationDao);

        context.checking(new Expectations() {{
            oneOf(mockStationDao).findById(stationsId);
            will(returnValue(findById(stationsId)));
        }});

        Station station = stationService.findById(stationsId);

        Assert.assertEquals(station.getId(),stationsId);

        context.assertIsSatisfied();
    }

    // imitating DB query
    public Station findById(int stationsId) {

        for (Station station:stationList) {
            if(station.getId()==stationsId){
                return station;
            }
        }

        return null;
    }


}
