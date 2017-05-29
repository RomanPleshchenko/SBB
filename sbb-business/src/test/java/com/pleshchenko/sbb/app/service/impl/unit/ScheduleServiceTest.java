package com.pleshchenko.sbb.app.service.impl.unit;

import com.pleshchenko.sbb.app.entity.schedule.*;
import com.pleshchenko.sbb.app.entity.ticket.Car;
import com.pleshchenko.sbb.app.repositories.interfaces.ScheduleDao;
import com.pleshchenko.sbb.app.repositories.interfaces.StationDao;
import com.pleshchenko.sbb.app.service.impl.ScheduleServiceImpl;
import com.pleshchenko.sbb.app.service.impl.StationServiceImpl;
import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
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
public class ScheduleServiceTest {

    private List<Schedule> scheduleList;
    private int scheduleId;
    private Schedule scheduleById;
    private String stationName = "Test";

    @Before
    public void setUp() {

        scheduleId = 777;
        scheduleById = new Schedule();
        scheduleById.setId(scheduleId);

        scheduleList = new ArrayList<>();
        scheduleList.add(new Schedule());
        scheduleList.add(new Schedule());
        scheduleList.add(new Schedule());
        scheduleList.add(scheduleById);

    }

    @Test
    public void getScheduleList() {

        Mockery context = new Mockery();
        final ScheduleDao mockDao = context.mock(ScheduleDao.class);

        ScheduleService service = new ScheduleServiceImpl(mockDao);

        context.checking(new Expectations() {{
            oneOf(mockDao).findAll();
            will(returnValue(scheduleList));
        }});

        List<Schedule> schedules = service.findAll();
        Assert.assertTrue(schedules.size()==scheduleList.size());
        Assert.assertTrue(schedules.size()!=0);
        context.assertIsSatisfied();

    }

    @Test
    public void getById() {

        Mockery context = new Mockery();
        final ScheduleDao mockDao = context.mock(ScheduleDao.class);

        ScheduleService service = new ScheduleServiceImpl(mockDao);

        context.checking(new Expectations() {{
            oneOf(mockDao).findById(scheduleId);
            will(returnValue(findById(scheduleId)));
        }});


        Schedule schedule = service.findById(scheduleId);
        Schedule schedule2 = new Schedule();

        Assert.assertEquals(schedule,scheduleById);
        Assert.assertNotEquals(schedule,schedule2);
        context.assertIsSatisfied();

    }


    // imitating DB query
    public Schedule findById(int scheduleId) {

        for (Schedule schedule:scheduleList) {
            if(schedule.getId()==scheduleId){
                return schedule;
            }
        }

        return null;
    }

}

