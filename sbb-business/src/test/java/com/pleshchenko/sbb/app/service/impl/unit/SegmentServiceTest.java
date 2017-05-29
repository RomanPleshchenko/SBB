package com.pleshchenko.sbb.app.service.impl.unit;

import com.pleshchenko.sbb.app.entity.schedule.Segment;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.repositories.interfaces.SegmentDao;
import com.pleshchenko.sbb.app.service.impl.SegmentServiceImpl;
import com.pleshchenko.sbb.app.service.impl.StationServiceImpl;
import com.pleshchenko.sbb.app.service.interfaces.SegmentService;
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
public class SegmentServiceTest {

    private List<Segment> segmentList;
    private Station stationA;
    private Station stationB;
    private Segment segmentAB;

    @Before
    public void setUp() {

        stationA = new Station("A");
        stationB = new Station("B");
        segmentAB = new Segment(stationA,stationB);

        segmentList = new ArrayList<>();

        segmentList.add(segmentAB);
        segmentList.add(new Segment());
        segmentList.add(new Segment());
        segmentList.add(new Segment());

    }

    @Test
    public void getSegmentsList() {

        Mockery context = new Mockery();
        final SegmentDao mock = context.mock(SegmentDao.class);
        SegmentService segmentService = new SegmentServiceImpl(mock);

        context.checking(new Expectations() {{
            oneOf(mock).findAll();
            will(returnValue(segmentList));
        }});

        List<Segment> segments = segmentService.findAll();
        Assert.assertTrue(segments.size()==segmentList.size());
        Assert.assertNotEquals(segments.size(),0);
        context.assertIsSatisfied();
    }

    @Test
    public void findByStation(){

        Mockery context = new Mockery();
        final SegmentDao segmentDao = context.mock(SegmentDao.class);
        SegmentService segmentService = new SegmentServiceImpl(segmentDao);

        context.checking(new Expectations() {{
            oneOf(segmentDao).findByStation(stationA,stationB,false);
            will(returnValue(segmentAB));
        }});

        Segment segment = segmentService.findByStation(stationA,stationB,false);
        Segment segment2 = new Segment(stationB,stationA);

        Assert.assertEquals(segmentAB,segment);
        Assert.assertTrue(segment2!=segment);

        context.assertIsSatisfied();

    }


}
