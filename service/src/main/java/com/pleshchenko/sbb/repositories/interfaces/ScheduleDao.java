package com.pleshchenko.sbb.repositories.interfaces;

import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.repositories.exceptions.NotEnoughParamsException;
import com.pleshchenko.sbb.service.other.ParametersForSearch;

import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
public interface ScheduleDao {

    Schedule findById(Integer id);

    List<Schedule> findAll();

    List<Schedule> findByStation(String stationName);

    List<Schedule> findByParameters(ParametersForSearch param);

    Schedule addByParameters(ParametersForSearch param) throws NotEnoughParamsException;

}