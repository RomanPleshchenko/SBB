package com.pleshchenko.sbb.service.repositories.interfaces;

import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.service.dto.other.ParametersForSearch;
import com.pleshchenko.sbb.service.repositories.exceptions.NotEnoughParamsException;

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
