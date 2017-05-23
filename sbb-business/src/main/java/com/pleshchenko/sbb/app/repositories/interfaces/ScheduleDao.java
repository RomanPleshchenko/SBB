package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
//import com.pleshchenko.sbb.app.repositories.exceptions.NotEnoughParamsException;
//import com.pleshchenko.sbb.app.service.other.ParametersForSearch;

import java.sql.Date;
import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
public interface ScheduleDao {

    Schedule findById(Integer id);

    List<Schedule> findAll();

    public List<Schedule> findUnComposedByRouteId(int routeId);

    public String getScheduleJSONByParameters(int st1,int st2,Date data1,Date data2);

    public List findFreeSite(int st1,int st2,int dirId,int routeId);

    List<Schedule> findByStation(String stationName);

    void save(Schedule dir);

    List<Schedule> findByTrainId(int trainId);
}
