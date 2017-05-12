package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Service("scheduleService")
@Transactional
public interface ScheduleService {

    Schedule findById(Integer id);

    List<Schedule> findAll();

    List<Schedule> findByParameters(int st1, int st2, Date data1, Date data2);

    public List findFreeSite(int st1,int st2,int dirId,int routeId);

    List<Schedule> findByStation(String stationName);

    void makeActive(int id);

    public void makeNotActive(int id);



}
