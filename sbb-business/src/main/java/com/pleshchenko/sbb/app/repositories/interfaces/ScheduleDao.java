package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.repositories.exceptions.NotEnoughParamsException;
import com.pleshchenko.sbb.app.service.other.ParametersForSearch;

import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
public interface ScheduleDao {

    Schedule findById(Integer id);

    List<Schedule> findAll();

    List<Schedule> findByStation(String stationName);

    void save(Schedule dir);

//    List<Schedule> findByParameters(ParametersForSearch param);
//
//    Schedule addByParameters(ParametersForSearch param) throws NotEnoughParamsException;

}
